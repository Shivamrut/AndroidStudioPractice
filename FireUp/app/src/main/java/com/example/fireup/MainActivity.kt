package com.example.fireup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fireup.data.DataSource
import com.example.fireup.model.Affirmations
import com.example.fireup.ui.theme.FireUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {

    AffirmationsList(affirmationsList = DataSource().loadAffirmations())


}

@Composable
fun AffirmationsList(affirmationsList: List<Affirmations>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier){
        items(affirmationsList){
            affirmation ->
            AffirmationCard(card = affirmation, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun AffirmationCard(card: Affirmations, modifier: Modifier = Modifier) {
    val img = card.imageResourceId
    val str = card.stringResourceId
    Card(
        modifier = modifier
    ) {
        Column {
            Image(
                painter = painterResource(id = img),
                contentDescription = stringResource(id = str),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = str),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AffirmationsAppPreview() {
    FireUpTheme {
        AffirmationsApp()
    }

}