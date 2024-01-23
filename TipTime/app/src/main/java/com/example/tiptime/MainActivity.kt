package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme
import org.jetbrains.annotations.VisibleForTesting
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme(
                darkTheme = false
            ) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var amountInput by remember {
        mutableStateOf("")
    }

    var tipInput by remember {
        mutableStateOf("")
    }

    var roundUp by remember {
        mutableStateOf(false)
    }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 15.0
    val tip = calculateTip(amount, tipPercent, roundUp)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {


        Text(
            text = "Calculate Tip", modifier = Modifier
                .padding(
                    bottom = 16.dp, top = 40.dp
                )
                .align(alignment = Alignment.Start)
                ,
            fontSize = 28.sp

        )
        EditNumberField(
            labelText = "Bill Amount",
            icon = R.drawable.icons8_money_50,
            value = amountInput,
            onValueChange = { amountInput = it },
            imeAction = ImeAction.Next,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        EditNumberField(
            labelText = "Tip Percentage",
            icon = R.drawable.icons8_percent_50,
            value = tipInput,
            onValueChange = { tipInput = it },
            imeAction = ImeAction.Done,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        RoundUpTip(
            roundUp,
            onValueChange = {
                roundUp = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)

        )
        Text(
            text = "Tip Amount : $tip",
//            modifier = Modifier
//                .padding(12.dp),
//            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    labelText: String, value: String, onValueChange: (String) -> Unit,
    imeAction: ImeAction,
    icon: Int,
    modifier: Modifier = Modifier
) {


    TextField(
        value = value,
//this way or adding icon in label
        leadingIcon = {
            androidx.compose.material3.Icon(
                painter = painterResource(id = icon), contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
        },

        onValueChange = onValueChange, modifier = modifier, label = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Icon(
//                    painter = painterResource(id = icon), contentDescription = "",
//                    modifier = Modifier
//                        .size(30.dp)
//                        ,
//
//                    )
//                Spacer(modifier = Modifier.padding(horizontal = 12.dp))


                Text(text = labelText,
                    fontSize = 20.sp)
            }

        }, singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        )
    )
}

@Composable
fun RoundUpTip(curValue: Boolean, onValueChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Round up tip?")

        Switch(checked = curValue, onCheckedChange = onValueChange)
    }
}

@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(
    showSystemUi = true, showBackground = true
)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout()
    }
}