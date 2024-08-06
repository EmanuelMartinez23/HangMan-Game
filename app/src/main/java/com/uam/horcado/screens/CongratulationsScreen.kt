package com.uam.horcado.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.uam.horcado.R
import com.uam.horcado.model.HorcadoModel
import com.uam.horcado.viewmodels.HorcadoViewModel

@Composable
fun CongratulationsScreen(
    horcadoViewModel: HorcadoViewModel, navController: NavHostController
) {

    Dialog(onDismissRequest = {  }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(410.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Text(
                    text = "COMPLETE",
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                    fontSize = 45.sp,
                    fontWeight =  FontWeight.W900,
                    color = Color.Black,
                    letterSpacing = 0.sp,
                    modifier =  Modifier.padding(top = 5.dp)
                )
                Row {
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                        text = "LEVEL ",
                        fontSize = 33.sp,
                        color = Color.Black
                    )
                    Text(
                        text = horcadoViewModel.nivel.value.toString(),
                        modifier = Modifier.padding(top = 5.dp),
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                        fontSize = 33.sp,
                        color = Color.Black
                    )

                }

                Image(
                    painter = painterResource(R.drawable.gift),
                    contentDescription = "gift",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .height(100.dp)
                        .width(100.dp)
                )

                Text(
                    text = "Score:",
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    fontSize = 33.sp,
                    color = Color.Black
                )
                Text(
                    text = "  ${horcadoViewModel.totalScore.value.toString()}  " ,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .clip(RoundedCornerShape(7.dp))
                    ,
                    style = TextStyle(background = Color.LightGray, fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    fontSize = 25.sp,
                    color = Color.Black,

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    IconButton(
                        onClick = { /* Regresar a la pagina principal */
                            horcadoViewModel.letrasUsadas.value = mutableListOf<Char>()
                            horcadoViewModel.intentos.value = 6
                            horcadoViewModel.nivel.value = 1
                            horcadoViewModel.totalScore.value= 0
                            horcadoViewModel.palabraSecretaIndex.value = HorcadoModel.getRandomWordIndex(horcadoViewModel.nivel.value)
                            //  regresamos a la pantalla principal
                            navController.navigate("principal")
                            {
                                // aseguramos que la pantalla de congratulations se cierre
                                popUpTo("congratulations") {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                                  },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.home), // Aquí utilizas el recurso de imagen del icono
                            contentDescription = "Icono para regresar a la pagina principal",
                            modifier = Modifier.height(50.dp).width(50.dp).padding(end = 20.dp),
                            tint = Color.Black
                        )
                    }
                    IconButton(
                        onClick = { /*Navegar al siguiente nivel */
                            horcadoViewModel.letrasUsadas.value = mutableListOf<Char>()
                            horcadoViewModel.nivel.value += 1
                            horcadoViewModel.intentos.value = 6
                            horcadoViewModel.palabraSecretaIndex.value = HorcadoModel.getRandomWordIndex(horcadoViewModel.nivel.value)
                            // Asegura que nos vamos a main y se elimine la screen de congratulations
                            navController.navigate("main"){
                                popUpTo("congratulations") {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }

                        },

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.next), // Aquí utilizas el recurso de imagen del icono
                            contentDescription = "Icono para avanzar el siguiente nivel",
                            modifier = Modifier.height(50.dp).width(50.dp).padding(end = 12.dp),
                            tint = Color.Black
                        )
                    }
                }
            }

        }//card
    }

}
