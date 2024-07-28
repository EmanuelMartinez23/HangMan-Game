package com.uam.horcado.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uam.horcado.R

// HorcadoViewModel contiene el estado y la logica relacionada con el juego

@Composable
fun creditsScreen( navController: NavHostController) {
    // Conseguimos del viewModel  el indice de la palabra secreta
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (modifier = Modifier.align(Alignment.Start)){

//
            IconButton(
                onClick = { /* Regresar a la pagina principal */
                    navController.navigate("principal")

                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back), // Aquí utilizas el recurso de imagen del icono
                    contentDescription = "Icono para regresar a la pagina principal",
                    modifier = Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .padding(top = 8.dp),
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "CREDITS",
                style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                fontSize = 45.sp,
                fontWeight =  FontWeight.W900,
                color = Color.Black,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )


        }
        Text(
            text = stringResource(id = R.string.credits),
            style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
            fontSize = 25.sp,
            modifier = Modifier.padding(30.dp),
            textAlign = TextAlign.Center
        )


    }


}
