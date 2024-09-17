package com.uam.hangman.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uam.hangman.ui.theme.HorcadoTheme

@Composable
fun anima(){

    var visible by remember { mutableStateOf(true) }
    Column (Modifier.background(Color.White)){
       Button(
           onClick = { /*TODO*/ }) {
           Text(text = "click")

       }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(
                // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                // Overwrites the default animation with tween
                animationSpec = tween(durationMillis = 250)
            )
        ) {
            // Content that needs to appear/disappear goes here:
            Text("Content to appear/disappear",
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(200.dp))
        }// ani

    }

}


@Preview
@Composable
fun pre(){
    HorcadoTheme {
        anima()
    }
}