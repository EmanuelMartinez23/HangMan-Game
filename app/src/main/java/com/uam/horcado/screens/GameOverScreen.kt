package com.uam.horcado.screens

import android.os.Build
import androidx.annotation.RequiresApi
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

// HorcadoViewModel contiene el estado y la logica relacionada con el juego

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GameOverScreen(horcadoViewModel: HorcadoViewModel, navController: NavHostController) {
    val palabraSecreta = horcadoViewModel.palabraDescubierta.value
  /*  val totalScore  = horcadoViewModel.totalScore.value
    val date = LocalDateTime.now()
    val year =  date.year
    val month =  date.month
    val day =  date.dayOfMonth
    val datee = "$year-$month-$day"
    val level = horcadoViewModel.nivel.value
    horcadoViewModel.listScores.value.add(totalScore.toString())
    horcadoViewModel.listScores.value.add(datee.toString())
    horcadoViewModel.listScores.value.add(level.toString())
    horcadoViewModel.listScores.value.add(palabraSecreta)
*/
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
                    text = "Game Over",
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                    fontSize = 45.sp,
                    fontWeight =  FontWeight.W900,
                    color = Color.Black,
                    letterSpacing = 0.sp,
                    modifier =  Modifier.padding(top = 5.dp)
                )

                Image(
                    painter = painterResource(R.drawable.gameover),
                    contentDescription = "gameover",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .height(100.dp)
                        .width(100.dp)
                )
                Row {
                    Text(
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                        text = "SOLUTION: ",
                        fontSize = 28.sp,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = palabraSecreta,
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                        fontSize = 23.sp,
                        color = Color.Black
                    )

                }

                Text(
                    text = "Score:",
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    fontSize = 28.sp,
                    color = Color.Black
                )
                Text(
                    text = " ${horcadoViewModel.totalScore.value} ",
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .clip(RoundedCornerShape(7.dp))
                    ,
                    style = TextStyle(background = Color.LightGray, fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    fontSize = 24.sp,
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
                            horcadoViewModel.palabraSecretaIndex.value = HorcadoModel.getRandomWordIndex()
                            navController.navigate("principal")
                            horcadoViewModel.nivel.value = 1

                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.retry), // Aquí utilizas el recurso de imagen del icono
                            contentDescription = "Icono para regresar a a intentar",
                            modifier = Modifier.height(50.dp).width(50.dp).padding(end = 20.dp),
                            tint = Color.Black
                        )
                    }
                    IconButton(
                        onClick = { /*Navegar al siguiente nivel */
                            horcadoViewModel.letrasUsadas.value = mutableListOf<Char>()
                            horcadoViewModel.intentos.value = 6
                            horcadoViewModel.palabraSecretaIndex.value = HorcadoModel.getRandomWordIndex()
                            navController.navigate("principal")
                            horcadoViewModel.nivel.value = 1
                            horcadoViewModel.totalScore.value = 0

                        },

                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.home), // Aquí utilizas el recurso de imagen del icono
                            contentDescription = "Icono para avanzar el siguiente nivel",
                            modifier = Modifier.height(50.dp).width(50.dp).padding(end = 12.dp),
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}
