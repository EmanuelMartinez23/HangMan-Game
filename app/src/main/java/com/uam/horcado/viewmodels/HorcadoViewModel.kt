package com.uam.horcado.viewmodels

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uam.horcado.model.HorcadoModel

class HorcadoViewModel : ViewModel() {

    val palabraSecretaIndex = mutableIntStateOf(HorcadoModel.getRandomWordIndex())

    val palabraDescubierta = mutableStateOf("")
    val intentos = mutableIntStateOf(6)
    val letrasUsadas = mutableStateOf(mutableListOf<Char>())
    val nivel = mutableIntStateOf(1)
    val score =  mutableIntStateOf(600)
    val totalScore =  mutableIntStateOf(0)
    val listScores = mutableStateOf(mutableListOf<String>())
}
