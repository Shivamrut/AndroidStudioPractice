package com.example.taskmanagercard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagercard.ui.theme.TaskManagerCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TaskCompletedScreen(info = stringResource(id = R.string.task_status),
                        appreciation = stringResource(id = R.string.info_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletedScreen(info : String,
                        appreciation : String,
                        modifier: Modifier = Modifier)
{
    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val image = painterResource(id = R.drawable.greentick)
        Image(
            painter = image,
            contentDescription = null,
            alignment = Alignment.Center
        )
        Text(
            text = info,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
            text = appreciation,
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun FinalScreenPreview() {
    TaskManagerCardTheme {
        TaskCompletedScreen(info = "Task completed", appreciation = "Good job")
    }
}