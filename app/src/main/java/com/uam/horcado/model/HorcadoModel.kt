package com.uam.horcado.model

// Contiene la lógica del modelo para el juego del ahorcado
// el model es el encargado de manegar los datos y la lógica del negocio de la app

object HorcadoModel {
    // función para obtener un índice aleatorio de una palabra en la lista
    fun getRandomWordIndex(): Int {
        return (0 until 90).random()
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
