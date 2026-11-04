
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val MatchCream = Color(0xFFFFF8EF)
private val MatchOrange = Color(0xFFF36F38)
private val MatchCoral = Color(0xFFD94D42)
private val MatchCarbon = Color(0xFF292824)
private val MatchGray = Color(0xFF77716A)
private val MatchGreen = Color(0xFF78866B)

@Composable
fun MatchesScreen(
    onQuickMatchClick: () -> Unit,
    onInviteClick: () -> Unit
) {
    var selectedMode by remember { mutableStateOf("1 contra 1") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MatchCream)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Zona de competición",
            fontSize = 27.sp,
            fontWeight = FontWeight.Black,
            color = MatchCarbon
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Demuestra quién manda en la cocina.",
            fontSize = 14.sp,
            color = MatchGray
        )

        Spacer(modifier = Modifier.height(22.dp))

        // BANNER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(
                    Brush.linearGradient(
                        listOf(
                            MatchOrange,
                            MatchCoral,
                            Color(0xFF9D3D32)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(22.dp)
            ) {
                Text(
                    "SPEED BATTLE",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "¿Preparado para el desafío?",
                    color = Color.White,
                    fontSize = 24.sp,
                    lineHeight = 29.sp,
                    fontWeight = FontWeight.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Entra en la cocina y compite.",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }

            Text(
                "⚔",
                fontSize = 65.sp,
                color = Color.White.copy(alpha = 0.18f),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(15.dp)
            )
        }

        Spacer(modifier = Modifier.height(27.dp))

        Text(
            "Elige tu modalidad",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MatchCarbon
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            "Selecciona cómo quieres competir.",
            fontSize = 13.sp,
            color = MatchGray
        )

        Spacer(modifier = Modifier.height(14.dp))

        ModeCard(
            title = "Duelo 1 contra 1",
            description = "Busca un rival y compite cara a cara.",
            icon = "⚔",
            selected = selectedMode == "1 contra 1",
            onClick = { selectedMode = "1 contra 1" }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ModeCard(
            title = "Partida privada",
            description = "Crea una sala para jugar con un amigo.",
            icon = "👥",
            selected = selectedMode == "Privada",
            onClick = { selectedMode = "Privada" }
        )

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = {
                if (selectedMode == "1 contra 1") {
                    onQuickMatchClick()
                } else {
                    onInviteClick()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MatchOrange
            )
        ) {
            Text(
                if (selectedMode == "1 contra 1")
                    "BUSCAR RIVAL"
                else
                    "CREAR PARTIDA PRIVADA",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            "Tus partidas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MatchCarbon
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MatchGreen.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("⚔", fontSize = 24.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Todavía no tienes partidas",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MatchCarbon
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "Tus partidas pendientes y activas aparecerán aquí cuando conectemos el backend.",
                    fontSize = 12.sp,
                    color = MatchGray,
                    lineHeight = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun ModeCard(
    title: String,
    description: String,
    icon: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                Color(0xFFFFE6D9)
            else
                Color.White
        ),
        border = if (selected) {
            androidx.compose.foundation.BorderStroke(
                1.5.dp,
                MatchOrange
            )
        } else {
            null
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        if (selected)
                            MatchOrange.copy(alpha = 0.15f)
                        else
                            MatchCream
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 22.sp)
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MatchCarbon
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    description,
                    fontSize = 12.sp,
                    color = MatchGray
                )
            }

            RadioButton(
                selected = selected,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = MatchOrange
                )
            )
        }
    }
}
