package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    FinalScreen()
                }
            }
        }
    }
}

@Composable
fun ScreenHead(modifier: Modifier=Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.androidcool)
        Spacer(modifier = Modifier.fillMaxHeight(0.1F))
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Shivamrut G",
            modifier = Modifier
                .padding(16.dp)
                ,

            fontSize = 32.sp,
           
        )
        Text(
            text = "Senior Software Architecture",
            modifier = Modifier.padding(bottom = 12.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#4B5320"))
        )
    }
}

@Composable
fun ScreenTail(modifier: Modifier = Modifier)
{
    Column (modifier = modifier
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        ContactBox(contactDetails = "+91 8310454296", icon = Icons.Default.Phone)
        ContactBox(contactDetails = "incineroaraditya@gmail.com", icon = Icons.Default.Email)
        ContactBox(contactDetails = "India", icon = Icons.Default.Place)
    }
}

@Composable
fun ContactBox(contactDetails : String, icon : ImageVector , modifier: Modifier = Modifier)
{
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .padding(start = 40.dp)
        ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.width(24.dp),
            tint = Color(android.graphics.Color.parseColor("#013220"))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contactDetails, fontSize = 16.sp, color = Color(android.graphics.Color.parseColor("#05472A")))

    }
}

@Composable
fun FinalScreen(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#BACC81")))
            .padding(16.dp)

            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScreenHead(Modifier.weight(3F))
        ScreenTail(Modifier.weight(1f))
    }
}
@Preview(showBackground = true
    ,
//    showSystemUi = true
)
@Composable
fun FinalScreenPreview() {
    BusinessCardTheme {
        FinalScreen()

    }
}