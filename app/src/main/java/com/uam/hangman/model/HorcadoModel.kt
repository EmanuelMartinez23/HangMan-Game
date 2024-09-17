package com.uam.hangman.model

// Contiene la lógica del modelo para el juego del ahorcado
// el model es el encargado de manegar los datos y la lógica del negocio de la app

object HorcadoModel {
    // función para obtener un índice aleatorio de una palabra en la lista
    // parametro level para sar que nivel esta y de acuerdo al nivel que se encuntra se regresa un numero en ese indice
    fun getRandomWordIndex(level: Int): Int {
        return when (level) {
            // si el nivel es de 1 o 2 regresar un indice de la lista de 0 a 20
            1, 2 -> (0 until 20).random()
            3, 4 -> (21 until 41).random()
            5, 6 -> (42 until 62).random()
            7, 8 -> (63 until 83).random()
            9, 10 -> (84 until 115).random()
            // en el caso de los niveles 11 a infinito, la letra seran de 116 a 162 para el index
            in 11 ..100 -> (116 until 162).random()
            // en dado caso de que el nivel  sea mayor a 100 regresara un  0
            else -> 0
        }

    }

    // funcion para verificar si una letra está presente en una palabra
    fun checkLetterInWord(word: String, letter: Char): Boolean {
        return word.contains(letter, ignoreCase = true)
    }

    // Función para actualizar una palabra descubierta con una letra encontrada
    fun updateDiscoveredWord(word: String, discoveredWord: String, letter: Char): String {
        // Creamos un StringBuilder a partir de la palabra descubierta
        val stringBuilder = StringBuilder(discoveredWord)
        // Iteramos sobre los caracteres de la palabra original
        for (i in word.indices) {
            // si el caracter actual es igual a la letra, actualizamos el StringBuilder
            if (word[i].equals(letter, ignoreCase = true)) {
                stringBuilder.setCharAt(i, letter)
            }
        }
        // Devolvemos la palabra descubierta actualizada como string
        return stringBuilder.toString()
    }


}
