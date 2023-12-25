package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    FinalScreen()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title : String,
             content : String,
             color : Color,
             modifier: Modifier = Modifier)
{
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
                )
    }
}

@Composable
fun FinalScreen(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)

        ) {
            Quadrant(title = stringResource(id = R.string.title1), content = stringResource(id = R.string.content1), 
                color = colorResource(id = R.color.color1), Modifier.weight
                (1f))
            Quadrant(title = stringResource(id = R.string.title2), content = stringResource(id = R.string.content2),
                color = colorResource(id = R.color.color2), Modifier.weight
                    (1f))        }
        Row (
            modifier = Modifier
                .weight(1f)

        ){
            Quadrant(title = stringResource(id = R.string.title3), content = stringResource(id = R.string.content3),
                color = colorResource(id = R.color.color3), Modifier.weight
                    (1f))
            Quadrant(title = stringResource(id = R.string.title4), content = stringResource(id = R.string.content4),
                color = colorResource(id = R.color.color4), Modifier.weight
                    (1f)) }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun FinalScreenPreview(modifier: Modifier = Modifier)
{
    ComposeQuadrantTheme {
        FinalScreen()
    }
}