package com.example.viewmessagesapp10

import android.content.res.Configuration
import android.graphics.Bitmap.Config
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewmessagesapp10.ui.theme.ViewMessagesApp10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewMessagesApp10Theme(
                darkTheme = false
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Conversation(messages = MsgData.messages)
                }
            }
        }
    }
}

class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(
    ) {
        items(messages) { message ->

            MessageCard(msg = message)
        }
    }
}

object MsgData {
    private const val author: String = "maxus_red"
    val messages = listOf(

        Message(author, "Conquer Android"),
        Message(
            author,
            "In the dark alley of Kotlin, nullability creeps, ready to ambush the unwary developer with its insidious NPEs."
        ),
        Message(
            author, "Behold the labyrinth of Compose, where simple UIs are lost in a thicket of declarative chaos." +
                    " Kotlin Coroutines, a maze of suspended animation – your code gasps for air in the twisted async underworld."
        ),
        Message(
            author,
            "Enter the kingdom of Jetpack – where navigation graphs weave a tapestry of confusion for the lost app traveler."
        ),
        Message(
            author,
            "A toast to the enigma of Compose animations – a ballet of transforms and states, leaving your UI in disarray."
        ),
        Message(
            author,
            "Fragments, the ghosts of the past, haunt the Android mansion, leaving behind a legacy of tangled lifecycles."
        ),
        Message(
            author,
            "Draw your sword against the monstrous beast, LiveData – a mutable siren song luring you into the sea of UI chaos."
        ),
        Message(
            author,
            "Gaze into the abyss of Compose modifiers – a cosmic dance of padding, size, and alignment, bending your UI to its will."
                    + "The saga of ViewModel unfolds – a mysterious oracle preserving state, yet testing the mettle of even the bravest architect."
        ),
        Message(
            author,
            "In the realm of Compose theming, the dark forces of color, typography, and shapes converge, bewitching the unsuspecting UI."
        )
    )
}

@Composable
fun MessageCard(msg: Message) {

    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        targetValue = if(isExpanded) Color.LightGray else MaterialTheme.colorScheme.surface
    )
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 5.dp,
        tonalElevation = 5.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable {
                isExpanded = !isExpanded
            },
        color = surfaceColor
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.jc),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(width = 3.dp, color = MaterialTheme.colorScheme.primary, shape = CircleShape)
            )
            Spacer(
                modifier = Modifier.padding(
                    horizontal = 8.dp
                )
            )
            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = msg.body,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.animateContentSize()
                )
            }
        }
    }


}


//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    name = "Dark Mode",
//    showSystemUi = true,
////    showBackground = true
//)
//@Composable
//fun MessageCardPreview1() {
//
//    ViewMessagesApp10Theme {
//        MessageCard(
//            msg = Message("maxus_red", "Conquer Android")
//        )
//    }
//
//
//}
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode",
    showSystemUi = true,
//    showBackground = true
)
@Composable
fun MessageCardPreview2() {

    ViewMessagesApp10Theme {
        Conversation(messages = MsgData.messages)
    }


}
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun MessageCardPreview3() {
//
//    ViewMessagesApp10Theme {
//        MessageCard(
//            msg = Message("maxus_red", "Conquer Android")
//        )
//    }
//
//
//}