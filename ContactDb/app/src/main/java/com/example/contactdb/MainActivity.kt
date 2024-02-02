@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.contactdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.contactdb.data.AddContactDialog
import com.example.contactdb.data.Contact
import com.example.contactdb.data.ContactDatabase
import com.example.contactdb.data.ContactEvent
import com.example.contactdb.data.ContactState
import com.example.contactdb.data.ContactViewModel
import com.example.contactdb.data.SortType
import com.example.contactdb.ui.theme.ContactDbTheme

class MainActivity : ComponentActivity() {

    private val dp by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()

    }

    private val viewModel by viewModels<ContactViewModel>(

        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(dp.dao) as T
                }

            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val demoContactList = listOf<Contact>(Contact("maxus", "red", "god"))


                    val state by viewModel.state.collectAsState()
                    ContactScreen(state = state, onEvent = viewModel::onEvent)
                }
            }
        }
    }
}

@Composable
fun ContactScreen(
    state: ContactState, onEvent: (ContactEvent) -> Unit
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            onEvent(ContactEvent.ShowDialog)
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")

        }
    },
        modifier = Modifier.padding(16.dp)) { paddingValues ->
        if(state.isAddingContact){
            AddContactDialog(state=state, onEvent = onEvent)
        }
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)


        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    SortType.values().forEach { sortType ->
                        Row(
                            Modifier.clickable {
                                onEvent(ContactEvent.SortContacts(sortType))
                            }, verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = state.sortType == sortType, onClick = {
                                onEvent(ContactEvent.SortContacts(sortType))
                            })
                            Text(text = sortType.name)

                        }
                    }
                }
            }

            items(state.contacts) { contact ->

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "${contact.firstName} ${contact.lastName}", fontSize = 20.sp
                        )
                        Text(
                            text = contact.phoneNumber, fontSize = 12.sp
                        )

                    }
                    IconButton(onClick = {
                        onEvent(ContactEvent.DeleteContact(contact))
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Contact")

                    }
                }

            }
        }

    }
}

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
                           onEvent(ContactEvent.HideDialog)
        },
        title = { Text(text = "Add Contact") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    },
                    placeholder = {
                        Text(text = "First Name")
                    }
                )

                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(it))
                    },
                    placeholder = {
                        Text(text = "Last Name")
                    }
                )

                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(it))
                    },
                    placeholder = {
                        Text(text = "Phone Number")
                    }
                )

            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                }) {

                    Text(text = "Save")
                }

            }
        }

    )


}