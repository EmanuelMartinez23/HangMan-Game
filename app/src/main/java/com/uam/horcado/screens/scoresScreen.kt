package com.uam.horcado.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uam.horcado.R
import com.uam.horcado.viewmodels.HorcadoViewModel

// HorcadoViewModel contiene el estado y la logica relacionada con el juego

@Composable
fun scoresScreen(horcadoViewModel: HorcadoViewModel , navController: NavHostController) {
    val listScores =  horcadoViewModel.listScores.value

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
                text = "SCORES",
                style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                fontSize = 45.sp,
                fontWeight =  FontWeight.W900,
                color = Color.Black,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )


        }
        Spacer(modifier = Modifier.height(25.dp))

        scoreDetail(
            position = 1,
            score = "2321",
            date = "12-02-2024",
            level = "23",
            word = "disponible"
        )
        Spacer(modifier = Modifier.height(5.dp))
        scoreDetail(2,score = "5421", date = "12-02-2024", level = "54" , word = "computadora" )
        Spacer(modifier = Modifier.height(5.dp))
        scoreDetail(3,score = "2654", date = "29-10-2024", level = "31" , word = "electricidad" )

    }
}


@Composable
fun scoreDetail(position:Int ,score: String,date : String, level: String, word : String ){
    Column(
        modifier = Modifier
            .width(350.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "${position}.- ",
                    fontSize = 30.sp,
                    color = Color.Black,
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "score:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "date:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "level:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "word:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )


            } // col1

            Spacer(modifier = Modifier.width(35.dp))

            Column {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = score.toString(),
                    fontSize = 25.sp,
                    color = Color.Gray,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = date,
                    fontSize = 25.sp,
                    color = Color.Gray,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = level.toString(),
                    fontSize = 25.sp,
                    color = Color.Gray,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = word,
                    fontSize = 25.sp,
                    color = Color.Gray,
                )
            } // col2
        } // row
    }
}
