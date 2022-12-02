package com.example.jetpackcomposeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeexamples.ui.theme.JetpackComposeExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner =  CornerSize(15.dp)),
            backgroundColor = Color.White,
            elevation = 4.dp ) {
            Surface(modifier = Modifier
                .size(150.dp)
                .padding(5.dp), shape = CircleShape,
                border = BorderStroke(0.5.dp, Color.LightGray),
                elevation = 4.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            ) {
                Image(painter = painterResource(id = com.example.jetpackcomposeexamples.R.drawable.image), contentDescription ="profileImage"
                    , modifier = Modifier.size(135.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExamplesTheme {
        Greeting("Android")
    }
}