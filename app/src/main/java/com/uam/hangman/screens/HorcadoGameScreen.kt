package com.uam.hangman.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.uam.hangman.R
import com.uam.hangman.model.HorcadoModel
import com.uam.hangman.ui.theme.HorcadoTheme
import com.uam.hangman.viewmodels.HorcadoViewModel


@Composable
fun HorcadoGameScreen(horcadoViewModel: HorcadoViewModel, navController: NavHostController) {
    // Listas de las palabras
    val palabrasList = stringArrayResource(id = R.array.palabras).toList()
    // Obtenemos los datos del viewModel
    // Indice de la palabra a jugar, indice va ser de acuerdo al level
    val palabraSecretaIndex = horcadoViewModel.palabraSecretaIndex.value
    // Seleccionamos la palabra de acuerdo a la lista
    val palabraSecreta = palabrasList[palabraSecretaIndex]
    val level = horcadoViewModel.nivel.value;

    var (palabraDescubierta, setPalabraDescubierta) = remember {
        mutableStateOf(
            "*".repeat(
                palabraSecreta.length
            )
        )
    }

    horcadoViewModel.palabraDescubierta.value = palabraSecreta
   // val palabraDescubierta2 = horcadoViewModel.palabraDescubierta.value
    val intentos = horcadoViewModel.intentos.value
    val letrasUsadas = horcadoViewModel.letrasUsadas.value
    val listScores  = horcadoViewModel.listScores.value
    val defaultButtonColor = Color.Black
//    val incorrectLetterColor = Color(0xFFCF6B7F)
    val incorrectLetterColor = Color(0xFFA60015)
    // Lista de letras del abecedario
    val abecedario = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val buttonColors = remember { abecedario.associateWith { mutableStateOf(Color(0xFFE9EBEA)) } }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_total),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LEVEL $level",
                style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                fontSize = 45.sp,
                fontWeight = FontWeight.W900,
                color = Color.Black,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(top = 5.dp, bottom = 29.dp)
            )
//            Image(
//                painter = painterResource(id = R.drawable.life6),
//                contentDescription = null,
//                modifier = Modifier.size(200.dp),
//                contentScale = ContentScale.Fit
//            )
            Image(
                painter = painterResource(
                    when (intentos) {
                        6 -> R.drawable.nivel1
                        5 -> R.drawable.life1
                        4 -> R.drawable.life2
                        3 -> R.drawable.life3
                        2 -> R.drawable.life4
                        1 -> R.drawable.life5
                        else -> R.drawable.life5
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit
            )

         Text(text = palabraDescubierta, fontSize = 28.sp, color =Color.Black)
            // Botones de letras del abecedario

            val filas = abecedario.chunked(5)
            filas.forEach { fila ->
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    fila.forEach { letra ->
                        val colorButton = remember { mutableStateOf(defaultButtonColor) }
                        TextButton(
                            onClick = {
                                if (!letrasUsadas.contains(letra)) {
                                    // Actualizamos las letras usadas en el viewModel
                                    horcadoViewModel.letrasUsadas.value =
                                        letrasUsadas.apply { add(letra) }

                                    // Verificamos si la letra está en la palabra secreta
                                    if (HorcadoModel.checkLetterInWord(palabraSecreta, letra)) {

                                        val nuevaPalabraDescubierta =
                                            HorcadoModel.updateDiscoveredWord(
                                                palabraSecreta, palabraDescubierta, letra
                                            )
                                        // Actualizamos la palabra descubierta en el ViewModel
                                        setPalabraDescubierta(nuevaPalabraDescubierta)

                                        // Si la palabra descubierta es igual a la palabra secreta, navegamos a la pantalla de congratulations
                                        if (palabraSecreta == nuevaPalabraDescubierta) {
                                            navController.navigate("congratulations")
                                            // asignamos el score de este nivel al total del score
                                            horcadoViewModel.totalScore.value += horcadoViewModel.score.value
                                            // reiniciamos el score del nivel al 600
                                            horcadoViewModel.score.value = 600
                                        }
                                    } else {
                                        // Si la letra no está en la palabra secreta, decrementamos los intentos
                                        horcadoViewModel.intentos.value -= 1
                                        horcadoViewModel.score.value -= 100
                                        colorButton.value = incorrectLetterColor
                                        // Si los intentos llegan a cero navegamos a la screen de gameOver
                                        if (horcadoViewModel.intentos.value == 0) {
                                            navController.navigate("gameOver")
                                            // si es que se pierde se reinician los puntajes
                                            horcadoViewModel.score.value = 600
                                            //horcadoViewModel.totalScore.value = 0
                                        }
//                                        buttonColors[letra]?.value = Color(0xFFCF6B7F)
                                    }
                                }
                            },
                            modifier = Modifier
                                .background(Color.Transparent),
                            //modifier = Modifier.padding(vertical = 1.dp, horizontal = 2.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
//                                containerColor = buttonColors[letra]?.value ?: Color(92,122,151,255),
                                contentColor = colorButton.value,
                            ),

                            //border = BorderStroke(3.dp, Color.Black)
                        ) {
                            Text(
                                text = letra.toString(),
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                                fontSize = 26.sp,
                                color = colorButton.value,
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun previ(){
    HorcadoTheme {
        HorcadoGameScreen(horcadoViewModel = viewModel(), navController = rememberNavController())

    }
}


