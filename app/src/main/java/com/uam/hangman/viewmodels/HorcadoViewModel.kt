package com.uam.hangman.viewmodels

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uam.hangman.model.HorcadoModel

/*
Clase para almacenar y gestionar datos relacionado con la ui
 */
class HorcadoViewModel : ViewModel() {
    // Guarda el estado de la palabra descubierta
    val palabraDescubierta = mutableStateOf("")
    // Estado de los intentos de cada ronda
    val intentos = mutableIntStateOf(6)
    // Lista de caracteres usados
    val letrasUsadas = mutableStateOf(mutableListOf<Char>())
    // Guarda el estado del nivel  actual
    val nivel = mutableIntStateOf(1)
    // Indice del la lista de palabras
    val palabraSecretaIndex = mutableIntStateOf(HorcadoModel.getRandomWordIndex(nivel.intValue))
    // Puntaje del juego en cada nivel
    val score =  mutableIntStateOf(600)
    // Suma de todos los puntajes
    val totalScore =  mutableIntStateOf(0)
    // lista de los scores mas
    val listScores = mutableStateOf(mutableListOf<String>())
}
