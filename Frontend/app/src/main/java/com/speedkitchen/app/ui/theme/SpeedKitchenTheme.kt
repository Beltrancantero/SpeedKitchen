
package com.speedkitchen.app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Colores oficiales de Speed Kitchen

val Cream = Color(0xFFFFF8EF)
val White = Color(0xFFFFFFFF)
val Orange = Color(0xFFF36F38)
val Carbon = Color(0xFF202321)
val Green = Color(0xFF72A67A)
val SoftGray = Color(0xFF77716A)
val LightGray = Color(0xFFF0EBE4)

// Configuración del tema claro

private val SpeedKitchenColors = lightColorScheme(
    primary = Orange,
    onPrimary = White,

    secondary = Green,
    onSecondary = White,

    background = Cream,
    onBackground = Carbon,

    surface = White,
    onSurface = Carbon,

    surfaceVariant = LightGray,
    onSurfaceVariant = SoftGray,

    error = Color(0xFFBA3333),
    onError = White
)

// Tema principal

@Composable
fun SpeedKitchenTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SpeedKitchenColors,
        shapes = androidx.compose.material3.Shapes(
            small = RoundedCornerShape(10.dp),
            medium = RoundedCornerShape(16.dp),
            large = RoundedCornerShape(22.dp)
        ),
        content = content
    )
}
