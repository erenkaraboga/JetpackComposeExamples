package com.example.jetpackcomposeexamples.portfolio
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeexamples.ui.theme.JetpackComposeExamplesTheme

class portfolio {
    @Composable
    fun Greeting(name: String) {
        val buttonClickedState = remember {
            mutableStateOf(false)
        }
        androidx.compose.material.Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(12.dp),
                    shape = RoundedCornerShape(corner =  CornerSize(15.dp)),
                    backgroundColor = Color.White,
                    elevation = 4.dp ) {
                    ProfileCard()
                }
                Divider( color = Color.Black)
                Box(modifier = Modifier.height(20.dp))
                HumanInfo()
                Button(onClick = {
                    buttonClickedState.value=!buttonClickedState.value
                }, colors=ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                    Text(text = "Show Portfolio", color = Color.White)

                }
                if (buttonClickedState.value){
                    Content()
                }
                else{
                    Box(){

                    }
                }

            }


        }
    }
    @Preview
    @Composable
    private fun Content(){
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp)){
            Surface(modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                border = BorderStroke(width = 2.dp,
                    color = Color.LightGray)
            ) {
                Portfolio(data = listOf("Project1","Project 2","Project 3"))
            }
        }
    }

    @Composable
    fun Portfolio(data: List<String>) {
        LazyColumn{
            items(data){ item -> Card(modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(), shape = RectangleShape, elevation = 4.dp) {
                Row(modifier = Modifier
                    .padding(4.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                    ProfileCard()
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great Project", style = MaterialTheme.typography.body2)
                    }

                }
            }
            }
        }
    }

    @Composable
    private fun HumanInfo() {
        Column() {
            Text(
                text = "Eren Karaboğa",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "Software Engineer",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "Mobile App Developer",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }

    @Composable
    private fun ProfileCard(modifier: Modifier=Modifier) {
        Surface(
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp), shape = CircleShape,
            border = BorderStroke(0.5.dp, Color.LightGray),
            elevation = 4.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
        ) {
            Image(
                painter = painterResource(id = com.example.jetpackcomposeexamples.R.drawable.image),
                contentDescription = "profileImage",
                modifier = modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetpackComposeExamplesTheme {
            Greeting("Android")
        }
    }
}