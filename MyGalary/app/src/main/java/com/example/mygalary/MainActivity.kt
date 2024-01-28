package com.example.mygalary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mygalary.ui.theme.MyGalaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalaryTheme (
                darkTheme = false
            ){
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GalleryLayout()
                }
            }
        }
    }
}

@Composable
fun GalleryLayout() {

    var index by remember {
        mutableIntStateOf(1)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        CurrentDisplay(
            index = index,

        )

        Spacer(modifier = Modifier.padding(vertical = 12.dp))

        DisplayText(index = index)

        ControlButtons(

            prevClick = {
                if (index > 1)
                    index--
                else index = 5
            }
        ) {
            if (index < 5)
                index++
            else index = 1
        }
    }

}

@Composable
fun CurrentDisplay(index: Int, modifier: Modifier = Modifier) {

    val img = when (index) {
        1 -> R.drawable.skeleton
        2 -> R.drawable.abstractface
        3 -> R.drawable.tree1
        4 -> R.drawable.superhuman
        5 -> R.drawable.viratkohli
        else -> R.drawable.skeleton
    }
    Surface(
        modifier = modifier
            .size(500.dp),
        shadowElevation = 10.dp,
//        tonalElevation = 2.dp// Optional: Add elevation for a lifted appearance
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "Current Picture",
                modifier = Modifier
                    .fillMaxSize(1f)
                    .align(Alignment.Center)
            )
        }

    }


}

@Composable
fun DisplayText(index: Int) {

    val (quote, author) = when (index) {
        1 -> Pair(R.string.WW_Q, R.string.WW)
        2 -> Pair(R.string.S_Q, R.string.S)
        3 -> Pair(R.string.RF_Q, R.string.RF)
        4 -> Pair(R.string.RD_Q, R.string.RD)
        5 -> Pair(R.string.SJ_Q, R.string.SJ)
        else -> Pair(R.string.WW_Q, R.string.WW)


    }


    Column(
        modifier = Modifier


            .fillMaxWidth()
            .size(120.dp)
            .background(color = Color.LightGray)
            .padding(4.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "\"" + stringResource(quote) + "\"",
            fontSize = 20.sp,
            lineHeight = 24.sp,

        )
        Text(
            text = stringResource(author),
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ControlButtons(prevClick: () -> Unit, nextClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically


    ) {
        Button(
            onClick = prevClick,
            modifier = Modifier.weight(4f)
        ) {
            Text(
                text = "Previous",
                fontSize = 12.sp
            )

        }
        Spacer(modifier = Modifier.weight(4f))
        Button(
            onClick = nextClick,
            modifier = Modifier.weight(4f)
        ) {
            Text(
                text = "Next",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GalleryLayoutPreview1() {
    MyGalaryTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            GalleryLayout()
        }
    }
}
