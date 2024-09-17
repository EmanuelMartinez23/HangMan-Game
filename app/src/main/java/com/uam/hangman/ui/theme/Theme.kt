package com.uam.hangman.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


@Composable
fun ChangeNavigationBarColor(
    color: Color,
    darkIcons: Boolean = false
) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.navigationBarColor = color.toArgb()

        WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = darkIcons
    }
}
@Composable
fun HorcadoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            // Cambiar color de la barra de navegación
            ChangeNavigationBarColor(
                color = if (darkTheme) Color.Black else Color.Black,
                darkIcons = !darkTheme
            )

            content()
        }
    )
}
