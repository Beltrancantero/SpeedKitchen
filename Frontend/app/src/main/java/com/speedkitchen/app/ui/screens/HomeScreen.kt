
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.speedkitchen.app.R

private val Cream = Color(0xFFFFF8EF)
private val Carbon = Color(0xFF292824)
private val Orange = Color(0xFFF36F38)
private val Coral = Color(0xFFD94D42)
private val SoftGray = Color(0xFF77716A)
private val Green = Color(0xFF78866B)

@Composable
fun HomeScreen(
    onRecipesClick: () -> Unit,
    onMatchesClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(18.dp))

        // CABECERA

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.cocina),
                contentDescription = "Logo Speed Kitchen",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "SPEED KITCHEN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black,
                    color = Carbon
                )

                Text(
                    text = "MIX WITH YOUR FRIENDS",
                    fontSize = 9.sp,
                    color = SoftGray,
                    letterSpacing = 1.5.sp
                )
            }

            IconButton(
                onClick = onProfileClick,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Text(
                    text = "👤",
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // BIENVENIDA

        Text(
            text = "¡Hola, chef!",
            fontSize = 29.sp,
            fontWeight = FontWeight.Black,
            color = Carbon
        )

        Text(
            text = "¿Qué vamos a cocinar hoy?",
            fontSize = 15.sp,
            color = SoftGray
        )

        Spacer(modifier = Modifier.height(22.dp))

        // BANNER PRINCIPAL

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(26.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.home_chef),
                contentDescription = "Chef preparando un plato",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xDD211C19)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
            ) {
                Text(
                    text = "COCINA · COMPITE · GANA",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Hoy es un buen día para cocinar.",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 29.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = onMatchesClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "BUSCAR PARTIDA →",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // RECETAS

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Explora la cocina",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Carbon,
                modifier = Modifier.weight(1f)
            )

            TextButton(onClick = onRecipesClick) {
                Text(
                    text = "Ver todas →",
                    color = Orange,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FoodCard(
                title = "Recetas",
                subtitle = "Descubre nuevos platos",
                image = R.drawable.recipe_pasta,
                modifier = Modifier.weight(1f),
                onClick = onRecipesClick
            )

            FoodCard(
                title = "Ingredientes",
                subtitle = "Prepara tu cocina",
                image = R.drawable.fresh_ingredients,
                modifier = Modifier.weight(1f),
                onClick = onRecipesClick
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // ACTIVIDAD

        Text(
            text = "Tu actividad",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Carbon
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Green.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✦", color = Green, fontSize = 24.sp)
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = "Tu historia empieza aquí",
                        color = Carbon,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Cuando juegues tus primeras partidas, aparecerá aquí tu actividad.",
                        color = SoftGray,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun FoodCard(
    title: String,
    subtitle: String,
    image: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(image),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = title,
                    color = Carbon,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = subtitle,
                    color = SoftGray,
                    fontSize = 11.sp
                )
            }
        }
    }
}
