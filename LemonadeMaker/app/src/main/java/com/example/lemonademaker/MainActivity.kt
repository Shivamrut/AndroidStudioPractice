package com.example.lemonademaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonademaker.ui.theme.LemonadeMakerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeMakerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LemonadeScreen()
                }
            }
        }
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,


    ) {
        var btnClick by remember {
            mutableIntStateOf(1)
        }
        var limitClick  by remember {
            mutableIntStateOf(4)
        }
        val (imageResource, textResource) = when (btnClick) {
            1 -> R.drawable.lemon_tree to R.string.tree_text
            2 -> R.drawable.lemon_squeeze to R.string.lemon_text
            3 -> R.drawable.lemon_drink to R.string.drink_text
            else -> R.drawable.lemon_restart to R.string.restart_text
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.app_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

                )
        }
        Spacer(
            modifier = Modifier
                .height(200.dp)
        )

        Box(
            modifier = modifier
        ) {

            Button(
                onClick = {

                    if (btnClick == 2 && limitClick>0) {
                        limitClick--
                    }
                    else{
                        btnClick++
                        if(btnClick == 2 && limitClick==0){
                            limitClick = Random.nextInt(3, 6)
                        }
                        else if (btnClick > 4) {
                            btnClick = 1
                        }
                    }


                },
                modifier = Modifier
                    .background(
                        colorResource(id = R.color.mint),
                        shape = RoundedCornerShape(20.dp)
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),


                ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null
                )

            }


        }

        Spacer(
            modifier = Modifier
                .height(28.dp)
        )
        Text(
            text = stringResource(id = textResource),
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadeScreenPreview(modifier: Modifier = Modifier) {
    LemonadeMakerTheme {
        LemonadeScreen()
    }
}