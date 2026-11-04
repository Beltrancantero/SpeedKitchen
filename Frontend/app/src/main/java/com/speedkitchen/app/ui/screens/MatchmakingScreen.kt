
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchmakingScreen(
    onCancelClick: () -> Unit,
    onMatchFoundClick: () -> Unit
) {
    val orange = Color(0xFFF36F38)
    val cream = Color(0xFFFFF8EF)
    val carbon = Color(0xFF292824)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(cream)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        listOf(orange, Color(0xFFD94D42))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "⚔",
                fontSize = 65.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Buscando rival...",
            fontSize = 27.sp,
            fontWeight = FontWeight.Black,
            color = carbon
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "Estamos preparando tu próximo desafío.",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(35.dp))

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
                .clip(RoundedCornerShape(10.dp)),
            color = orange,
            trackColor = Color(0xFFE9DED3)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "MODO DEMOSTRACIÓN",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = orange,
            letterSpacing = 1.5.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Como todavía no tenemos el matchmaking conectado al servidor, puedes simular que se encuentra un rival.",
            fontSize = 13.sp,
            color = Color.Gray,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = onMatchFoundClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = orange
            )
        ) {
            Text(
                "SIMULAR RIVAL ENCONTRADO",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onCancelClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Cancelar búsqueda", color = carbon)
        }
    }
}
