
package com.speedkitchen.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.speedkitchen.app.R

private val WelcomeOrange = Color(0xFFF36F38)
private val WelcomeCoral = Color(0xFFD94D42)
private val WelcomeCream = Color(0xFFFFF8EF)

@Composable
fun PantallaBienvenida(
    onStartClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WelcomeCream)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // FOTOGRAFÍA PRINCIPAL

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.home_chef),
                    contentDescription = "Chef preparando un plato",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Degradado sobre la fotografía

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    0.0f to Color(0x88000000),
                                    0.35f to Color(0x33000000),
                                    0.65f to Color(0x99000000),
                                    1.0f to Color(0xF0000000)
                                )
                            )
                        )
                )

                // LOGO

                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.cocina),
                        contentDescription = "Logo Speed Kitchen",
                        modifier = Modifier.size(48.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "SPEED KITCHEN",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Black
                        )

                        Text(
                            text = "MIX WITH YOUR FRIENDS",
                            color = Color.White,
                            fontSize = 9.sp,
                            letterSpacing = 1.2.sp
                        )
                    }
                }

                Text(
                    text = "EL SABOR DE LA COMPETICIÓN",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(24.dp),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            }

            // PANEL INFERIOR

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                WelcomeOrange,
                                WelcomeCoral
                            )
                        )
                    )
                    .padding(
                        horizontal = 25.dp,
                        vertical = 28.dp
                    )
            ) {

                Text(
                    text = "COCINA. COMPITE.\nSUPÉRATE.",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 37.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "El talento se demuestra entre fogones. Desafía a tus amigos y descubre quién domina la cocina.",
                    color = Color.White.copy(alpha = 0.95f),
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onStartClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = WelcomeCream,
                        contentColor = WelcomeCoral
                    )
                ) {
                    Text(
                        text = "COMENZAR  →",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "MIX WITH YOUR FRIENDS",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 10.sp,
                    letterSpacing = 2.sp
                )
            }
        }
    }
}
