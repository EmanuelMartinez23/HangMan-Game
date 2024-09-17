package com.uam.hangman.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.outlined.Home
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
import com.uam.hangman.R
import com.uam.hangman.model.HorcadoModel
import com.uam.hangman.viewmodels.HorcadoViewModel

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
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Dialog(onDismissRequest = { }) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(410.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Box(modifier = with(Modifier){
                        fillMaxSize().paint(
                            painter = painterResource(id = R.drawable.pantallagameover),
                            contentScale = ContentScale.FillBounds
                        )
                    } ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {

                            Spacer(modifier = Modifier.height(222.dp))
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
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold

                                )

                            }

                            Text(
                                text = "Score:",
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                                fontSize = 28.sp,
                                color = Color.Black
                            )
                            Text(
                                text = " ${horcadoViewModel.totalScore.value} ",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(7.dp)),
                                style = TextStyle(
                                    background = Color.Transparent,
                                    fontFamily = FontFamily(Font(R.font.indieflower_regular))
                                ),
                                fontSize = 28.sp,
                                color = Color.Black,

                                )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                IconButton(
                                    onClick = { /* Regresar a la pagina principal */
                                        horcadoViewModel.letrasUsadas.value = mutableListOf<Char>()
                                        horcadoViewModel.nivel.value = 1
                                        horcadoViewModel.intentos.value = 6
//                            horcadoViewModel.score.value= 0 //
                                        horcadoViewModel.totalScore.value = 0 //
                                        horcadoViewModel.palabraSecretaIndex.value =
                                            HorcadoModel.getRandomWordIndex(horcadoViewModel.nivel.value)
                                        navController.navigate("principal")

                                    },
                                ) {
                                    Icon(
                                        Icons.Rounded.Refresh,
                                        contentDescription =null,
                                        tint = Color.Black,
                                        modifier =Modifier.size(100.dp))
                                }
                                Spacer(modifier = Modifier.width(40.dp))
                                IconButton(
                                    onClick = { /*Navegar a la screen de inicio */
                                        horcadoViewModel.letrasUsadas.value = mutableListOf<Char>()
                                        horcadoViewModel.intentos.value = 6
                                        horcadoViewModel.nivel.value = 1
                                        horcadoViewModel.palabraSecretaIndex.value =
                                            HorcadoModel.getRandomWordIndex(horcadoViewModel.nivel.value)
                                        navController.navigate("principal")
                                        horcadoViewModel.totalScore.value = 0

                                    },

                                    ) {

                                    Icon(
                                        Icons.Outlined.Home,
                                        contentDescription =null,
                                        tint =Color.Black,
                                        modifier =Modifier.size(100.dp))
                                }
                            }
                        }
                    }// box 2


                } //card

            }//dialog

    }
}