package com.uam.hangman.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uam.hangman.R
import com.uam.hangman.viewmodels.HorcadoViewModel

// HorcadoViewModel contiene el estado y la logica relacionada con el juego
@Composable
fun scoresScreen(horcadoViewModel: HorcadoViewModel , navController: NavHostController) {
    val listScores = horcadoViewModel.listScores.value

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pantallascore),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(130.dp))
            scoreDetail(
                position = 1,
                score = "2321",
                date = "12-02-2024",
                level = "23",
                word = "disponible"
            )
            Spacer(modifier = Modifier.height(5.dp))
            scoreDetail(2, score = "5421", date = "12-02-2024", level = "54", word = "hongo")
            Spacer(modifier = Modifier.height(5.dp))
            scoreDetail(3, score = "2654", date = "29-10-2024", level = "31", word = "playera")

        }
    }
}


@Composable
fun scoreDetail(position:Int ,score: String,date : String, level: String, word : String ){
    Column(
        modifier = Modifier
            .width(350.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column {
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "${position}.- ",
                    fontSize = 30.sp,
                    color = Color.Black,
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "score:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "date:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "level:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = "word:",
                    fontSize = 25.sp,
                    color = Color.Black,
                )


            } // col1

            Spacer(modifier = Modifier.width(30.dp))

            Column {
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = score.toString(),
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = date,
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = level.toString(),
                    fontSize = 25.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
                    text = word,
                    fontSize = 25.sp,
                    color = Color.Black,
                )
            } // col2
        } // row
    }
}
