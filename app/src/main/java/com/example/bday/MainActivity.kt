package com.example.bday


import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bday.ui.theme.BdayTheme
import com.example.bday.ui.theme.gabrielleFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BdayTheme {
                Surface (modifier = Modifier.fillMaxSize(),
                        color  = MaterialTheme.colorScheme.background

                ) {
                    GreetingImage(from = stringResource(R.string.lipo), message = stringResource(R.string.happy_happy),
                        modifier = Modifier.padding(8.dp)
                        )

                }
            }
        }
    }
}

@Composable
fun GreetingImage(message : String, from : String, modifier : Modifier = Modifier ){
    val image = painterResource(id = R.drawable.androidparty)
    Box ( modifier ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )

        GreetingText(from = from, message = message,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }

}


@Composable
fun GreetingText( from : String, message : String, modifier: Modifier= Modifier){
    Column (modifier = modifier,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}


@Preview(showBackground = true, name = "No NAME")
@Composable
fun BirthdayCardPreview() {
    BdayTheme {
        GreetingImage(message = stringResource(id = R.string.happy_happy), from = stringResource(id = R.string.lipo))

    }
}