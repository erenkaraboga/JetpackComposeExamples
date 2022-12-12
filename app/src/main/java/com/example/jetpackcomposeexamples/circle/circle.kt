package com.example.jetpackcomposeexamples.circle

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class circle {
    @Preview
    @Composable
fun MyApp(){
        var moneyCounterr = remember {
            mutableStateOf(0)
        }
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Text(text = "${moneyCounterr.value}", style = TextStyle(fontSize = 35.sp))
            Spacer(modifier = Modifier.height(20.dp))
            CreateCircle(moneyCounterr.value, updateMoney = {
               newValue -> moneyCounterr.value=newValue
            })
        }
    }
}

@Composable
fun CreateCircle(moneyCount : Int, updateMoney:(Int) -> Unit){


    Card(modifier = Modifier
        .padding(3.dp)
        .size(70.dp)
        .clickable {
            updateMoney(moneyCount+1)
            Log.d("Tapp", "Money Increment")
        }, shape = CircleShape, elevation = 10.dp) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap ${moneyCount}",)
        }

    }
}
}