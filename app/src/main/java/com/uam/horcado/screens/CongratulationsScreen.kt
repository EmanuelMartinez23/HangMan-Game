package com.uam.horcado.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
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

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Dialog(onDismissRequest = {  }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(410.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Box(modifier =  with(Modifier){
                    fillMaxSize().paint(
                        painterResource(id = R.drawable.pantallacomplete),
                        contentScale = ContentScale.FillBounds
                    )
                }  ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Spacer(modifier = Modifier.height(222.dp))
                        Row {
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                                text = "LEVEL ",
                                fontSize = 28.sp,
                                color = Color.Black
                            )
                            Text(
                                text = horcadoViewModel.nivel.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                                fontSize = 28.sp,
                                color = Color.Black
                            )

                        }
                        Text(
                            text = "Score:",
                            style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                            fontSize = 28.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "  ${horcadoViewModel.totalScore.value.toString()}  " ,
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .clip(RoundedCornerShape(7.dp))
                            ,
                            style = TextStyle(background = Color.Transparent, fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                            fontSize = 28.sp,
                            color = Color.Black,

                            )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
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
                                    Icons.Outlined.Home,
                                    contentDescription = "Icono para regresar a la pagina principal",
                                    modifier = Modifier.size(200.dp),
                                    tint = Color.Black
                                )
                            }

                            Spacer(modifier = Modifier.width(20.dp))
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
                                    Icons.Outlined.ArrowForward,
                                    contentDescription = "Icono para avanzar el siguiente nivel",
                                    modifier = Modifier.size(200.dp),
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }


            }//card
        } // Dialog

    }


}
