package com.example.mygalary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygalary.ui.theme.MyGalaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxHeight().fillMaxWidth(), color = MaterialTheme.colorScheme.background) {
                    GalleryLayout()
                }
            }
        }
    }
}

@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize()

    ) {

        CurrentDisplay(
            modifier = Modifier
        )

        Spacer(modifier = Modifier.padding(vertical = 30.dp))

        DisplayText()

        ControlButtons()
    }

}

@Composable
fun CurrentDisplay(modifier: Modifier = Modifier ) {
    Box(modifier = modifier) {

        Image(painter = painterResource(id = R.drawable.skeleton), contentDescription = "skeleton",
            modifier = Modifier
                .size(50.dp))

    }
}

@Composable
fun DisplayText( ) {
    Column {
        Text(text = "Every man dies but not every man really lives")
        Text(text = "William Wallace")
    }
}

@Composable
fun ControlButtons() {
    Row {
        Button(onClick = { /*TODO*/ }) {

        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GalleryLayoutPreview1() {
    MyGalaryTheme {
        Surface(modifier = Modifier.fillMaxHeight().fillMaxWidth(), color = MaterialTheme.colorScheme.background) {
            GalleryLayout()
        }
    }
}
//@Preview (
//    showBackground = true,
////    showSystemUi = true
//)
//@Composable
//fun GalleryLayoutPreview2() {
//    MyGalaryTheme {
//        CurrentDisplay()
//    }
//}