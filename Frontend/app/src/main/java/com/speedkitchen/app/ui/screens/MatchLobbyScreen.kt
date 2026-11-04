
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchLobbyScreen(
    onBackClick: () -> Unit,
    onPrepareClick: () -> Unit
) {
    val orange = Color(0xFFF36F38)
    val cream = Color(0xFFFFF8EF)
    val carbon = Color(0xFF292824)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(cream)
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "SALA DE PARTIDA",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = orange,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "¡Tenemos enfrentamiento!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Black,
            color = carbon
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PlayerCard(
                name = "Tú",
                label = "Jugador",
                color = orange
            )

            Text(
                "VS",
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                color = carbon
            )

            PlayerCard(
                name = "Chef Demo",
                label = "Rival ficticio",
                color = Color(0xFF78866B)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    "¿Qué viene ahora?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = carbon
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "1. Seleccionar una receta.",
                    fontSize = 14.sp,
                    color = carbon
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "2. Preparar ingredientes y utensilios.",
                    fontSize = 14.sp,
                    color = carbon
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "3. Comenzar el desafío de cocina.",
                    fontSize = 14.sp,
                    color = carbon
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    "Esta sala es una demostración. Los jugadores reales y la sincronización llegarán con el backend.",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    lineHeight = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onPrepareClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = orange
            )
        ) {
            Text(
                "CONTINUAR A RECETAS",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = onBackClick) {
            Text("Salir de la sala", color = carbon)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun PlayerCard(
    name: String,
    label: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(85.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.18f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                name.take(1).uppercase(),
                fontSize = 35.sp,
                fontWeight = FontWeight.Black,
                color = color
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            label,
            fontSize = 11.sp,
            color = Color.Gray
        )
    }
}
