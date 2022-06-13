package com.example.santaderdiobootcampmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.santaderdiobootcampmobile.ui.theme.SantaderDioBootcampMobileTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SantaderDioBootcampMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var visibility by remember {
            mutableStateOf(false)
        }

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                ) {
                    append("Dio ")
                }
                append("and ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                ) {
                    append("Santander ")
                }
                append("Bootcamp Mobile 2022")
            },
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_100)))

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(tween(800)) + expandVertically()
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Introduction to Git and Github \n My first project",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }

        LaunchedEffect("visibility") {
            delay(600)
            visibility = true
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SantaderDioBootcampMobileTheme {
        Greeting()
    }
}