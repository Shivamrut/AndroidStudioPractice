package com.example.findcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.findcourses.ui.theme.FindCoursesTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindCoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CourseList2(
                        dataList = Course().loadCoursesData()
                    )
                }
            }
        }
    }
}

//      modifier: Modifier = Modifier

@Composable
fun CourseCard(data: CourseData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(68.dp)
            .width(187.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(data.imageResource),
                contentDescription = stringResource(id = data.stringResource),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
//                        end = 16.dp,
                        top = 16.dp,

                        ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = data.stringResource), maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        bottom = 8.dp
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_grain
                        ),
                        contentDescription = "icon for number of courses",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = Random.nextInt(10, 400).toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseList(dataList: List<CourseData>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(dataList) { data ->
            CourseCard(
                data = data,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CourseList2(dataList: List<CourseData>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(dataList) { data ->
            CourseCard(
                data = data, modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Preview
    (
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CoursesPreview() {
    FindCoursesTheme {
        CourseList(dataList = Course().loadCoursesData())

    }
}

//@Preview
//    (
////    showSystemUi = true,
////    showBackground = true
//)
//@Composable
//fun CoursesPreview2() {
//    FindCoursesTheme {
//
//        CourseCard(
//            data = CourseData(R.drawable.architecture, R.string.architecture),
//            modifier = Modifier
//
//        )
//    }
//}

@Preview
    (
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CoursesPreview3() {
    FindCoursesTheme {
        CourseList2(dataList = Course().loadCoursesData())

    }
}