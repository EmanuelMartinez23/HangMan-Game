package com.uam.horcado


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uam.horcado.screens.CongratulationsScreen
import com.uam.horcado.screens.GameOverScreen
import com.uam.horcado.screens.HorcadoGameScreen
import com.uam.horcado.screens.creditsScreen
import com.uam.horcado.screens.mainScreen
import com.uam.horcado.screens.scoresScreen
import com.uam.horcado.ui.theme.HorcadoTheme
import com.uam.horcado.viewmodels.HorcadoViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorcadoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val horcadoViewModel: HorcadoViewModel = viewModel()
                    val navController = rememberNavController()
                    MyApp(navController, horcadoViewModel)
                }
            } //
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(navController: NavHostController, horcadoViewModel: HorcadoViewModel) {
    NavHost(
        navController = navController,
        startDestination = "principal"
    ) {
        composable("main") {
            //val argument = backStackEntry.arguments?.getString("argument")
            HorcadoGameScreen(horcadoViewModel, navController)
        }
        composable("principal") {
            //val argument = backStackEntry.arguments?.getString("argument")
            mainScreen(horcadoViewModel, navController)
        }

        composable("gameOver") {
            GameOverScreen(horcadoViewModel, navController)
        }
        composable("scores") {
            scoresScreen(horcadoViewModel,navController)
        }
        composable("credits") {
            creditsScreen( navController)
        }
        composable("congratulations") {
            //val argument = backStackEntry.arguments?.getString("argument")
            CongratulationsScreen(horcadoViewModel, navController)
        }
    }
}

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorcadoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFFFFF)
                ) {
                    MyApp()
                }
            } //
        }
    }
}

// Logica para la navegación
@Composable
fun MyApp() {
    val inicioValue =  (0..90).random()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main/{argument}"
    ) {

        composable("main/{argument}") {backStackEntry ->
            val argument = backStackEntry.arguments?.getString("argument")
            HorcadoGame(navController, argument?.toInt() ?: inicioValue)
        }

        composable("gameOver/{argument}") { backStackEntry ->
            val argument = backStackEntry.arguments?.getString("argument")
            gameOver(navController, argument)
        }
        composable("congratulations/{argument}") { backStackEntry ->
            val argument = backStackEntry.arguments?.getString("argument")
            congratulations(navController, argument?.toInt() ?: 0)
        }
    }

}

// Logica para la pantalla de congratulations
@Composable
fun congratulations(navController: NavHostController, toInt: Int){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                R.drawable.congra
            ),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Spacer(modifier = Modifier.height(45.dp))
        OutlinedButton(
            onClick = {

                    navController.navigate("main/${toInt + 1 }")
            },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
            )

        ) {
            Text("Volver a jugar")
        }
    }

}


// Logica para la pantalla de gameOver
@Composable
fun gameOver(navController: NavHostController, argument: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                R.drawable.gameover
            ),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        //Text(text = "Game Over")
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text(
                text="Solución: ",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = argument.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }
        Spacer(modifier = Modifier.height(45.dp))
        OutlinedButton(
            onClick = {
                var rango1a100 = 0..92
                navController.navigate("main/${rango1a100.random()}")
            },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
        )
        ) {
            Text("Volver a jugar")
        }
    }
}

// Logica del juego
@Composable
fun HorcadoGame(navController: NavHostController,indexOf: Int) {
    val palabrasList = stringArrayResource(id = R.array.palabras).toList()

    val palabraSecreta   =  palabrasList[indexOf]
    val (palabraDescubierta, setPalabraDescubierta) = remember {
        mutableStateOf(
            "*".repeat(
                palabraSecreta.length
            )
        )
    }

    val (intentos, setIntentos) = remember { mutableStateOf(6) }
    val (letrasUsadas, setLetrasUsadas) = remember { mutableStateOf(mutableListOf<Char>()) }

    val abecedario = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val buttonColors = remember { abecedario.associateWith { mutableStateOf(Color(0xFFFFFAFA)) } }
    val filas = abecedario.chunked(5)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text(text = palabraSecreta)
        Image(
            painter = painterResource(
                when (intentos) {
                    6 -> R.drawable.uno
                    5 -> R.drawable.dos
                    4 -> R.drawable.tres
                    3 -> R.drawable.cuatro
                    2 -> R.drawable.cinco
                    1 -> R.drawable.seis
                    else -> R.drawable.gameover
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = palabraDescubierta, fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        filas.forEach { fila ->
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                fila.forEach { letra ->
                    Button(
                        onClick = {
                            if (!letrasUsadas.contains(letra)) {
                                setLetrasUsadas(letrasUsadas.apply { add(letra) })
                                if (palabraSecreta.contains(letra)) {//2
                                    val nuevaPalabraDescubierta =
                                        palabraSecreta.map { if (letrasUsadas.contains(it)) it else '*' }
                                            .joinToString("")
                                    setPalabraDescubierta(nuevaPalabraDescubierta)
                                    if(palabraSecreta == nuevaPalabraDescubierta){
                                        navController.navigate("congratulations/$indexOf")

                                    }

                                } else {//2
                                    setIntentos(intentos - 1)
                                    if (intentos - 1 == 0) {
                                       // setPalabraDescubierta(palabraSecreta)
                                        setIntentos(0)
                                        navController.navigate("gameOver/$palabraSecreta")

                                    }
                                    buttonColors[letra]?.value = Color.Red
                                }
                            } // grande
                        },
                        modifier = Modifier
                            .padding(vertical = 1.dp, horizontal = 2.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor  = buttonColors[letra]?.value ?: Color(0xFFFFFAFA),
                            contentColor = Color(0xFF000000),
                        ),
                        border = BorderStroke(3.dp,Color(0xFF000000))
                    ) {
                        Text(text = letra.toString())
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun previewMyApp2(){
    HorcadoTheme {
        MyApp()
    }

}
*/
