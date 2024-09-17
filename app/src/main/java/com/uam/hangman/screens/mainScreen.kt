package com.uam.hangman.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.uam.hangman.R
import com.uam.hangman.ui.theme.HorcadoTheme
import com.uam.hangman.viewmodels.HorcadoViewModel

// HorcadoViewModel contiene el estado y la logica relacionada con el juego
@Composable
fun mainScreen(horcadoViewModel: HorcadoViewModel, navController: NavHostController) {

    Box(modifier =Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.pantallainicio), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth)
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "HANGMAN",
                style = TextStyle(fontFamily = FontFamily(Font(R.font.atma_semibold))),
                fontSize = 45.sp,
                fontWeight =  FontWeight.W900,
                color = Color.Black,
                letterSpacing = 0.sp,
                modifier =  Modifier.padding(top = 5.dp)
            )

            Spacer(modifier = Modifier.height(308.dp))
            Column {
                OutlinedButtonPer(
                    texto ="Play",
                    onClick = {navController.navigate("main")} )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButtonPer(
                    texto ="Scores",
                    onClick = {navController.navigate("scores")} )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButtonPer(
                    texto ="Credits",
                    onClick = {navController.navigate("credits")} )

            }
        }
    }
}

@Composable
fun OutlinedButtonPer(texto :String , onClick : () -> Unit,  ){
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .width(240.dp)
            .height(70.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
        ),
        border = BorderStroke(width = 4.dp,color = Color.Black),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = texto,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.indieflower_regular))),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            letterSpacing = 0.sp,

            )
    }

}


@Preview
@Composable
fun previevMainScreen (){
    HorcadoTheme {
        mainScreen(horcadoViewModel = viewModel(), navController = rememberNavController())
    }
}