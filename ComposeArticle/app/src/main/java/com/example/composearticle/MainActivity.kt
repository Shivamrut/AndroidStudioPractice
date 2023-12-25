package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleContent(
                        title = stringResource(id = R.string.article_title),
                        intro = stringResource(id = R.string.article_intro),
                        content = stringResource(id = R.string.article_content)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleContent(
    title : String,
    intro : String,
    content : String,
    modifier : Modifier = Modifier)
{
    Column (
        modifier = modifier
    ){
        val image = painterResource(id = R.drawable.article_backgorund)
        Image(painter = image ,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()

        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = intro,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Text(
            text = content,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        ArticleContent(title = "JC", intro = "Hello", content = "Some text")
    }
}