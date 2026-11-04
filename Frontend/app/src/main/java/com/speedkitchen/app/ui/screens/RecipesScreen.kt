
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.speedkitchen.app.R

private val RecipesCream = Color(0xFFFFF8EF)
private val RecipesOrange = Color(0xFFF36F38)
private val RecipesCarbon = Color(0xFF292824)
private val RecipesGray = Color(0xFF77716A)
private val RecipesGreen = Color(0xFF78866B)

private data class Recipe(
    val id: String,
    val name: String,
    val category: String,
    val difficulty: String,
    val duration: String,
    val image: Int
)

@Composable
fun RecipesScreen(
    onRecipeClick: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Todas") }

    val categories = listOf(
        "Todas", "Pasta", "Carnes", "Pescados", "Postres"
    )

    val recipes = listOf(
        Recipe(
            "pasta",
            "Pasta cremosa con tomate",
            "Pasta",
            "Fácil",
            "25 min",
            R.drawable.recipe_pasta
        ),
        Recipe(
            "pollo",
            "Pollo salteado con verduras",
            "Carnes",
            "Media",
            "40 min",
            R.drawable.home_chef
        ),
        Recipe(
            "salmon",
            "Salmón con verduras",
            "Pescados",
            "Fácil",
            "30 min",
            R.drawable.fresh_ingredients
        ),
        Recipe(
            "tarta",
            "Tarta de chocolate",
            "Postres",
            "Difícil",
            "50 min",
            R.drawable.cooking_chef
        )
    )

    val filteredRecipes = recipes.filter { recipe ->
        (selectedCategory == "Todas" ||
                recipe.category == selectedCategory) &&
                recipe.name.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RecipesCream)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "Descubre recetas",
            fontSize = 28.sp,
            fontWeight = FontWeight.Black,
            color = RecipesCarbon
        )

        Text(
            text = "Encuentra tu próximo desafío culinario.",
            fontSize = 14.sp,
            color = RecipesGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Buscar una receta...")
            },
            leadingIcon = {
                Text("⌕", fontSize = 25.sp)
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RecipesOrange,
                unfocusedBorderColor = Color(0xFFE5DDD3),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Categorías",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = RecipesCarbon
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                val selected = selectedCategory == category

                Surface(
                    onClick = { selectedCategory = category },
                    shape = RoundedCornerShape(50),
                    color = if (selected) RecipesOrange else Color.White
                ) {
                    Text(
                        text = category,
                        modifier = Modifier.padding(
                            horizontal = 14.dp,
                            vertical = 10.dp
                        ),
                        color = if (selected) Color.White else RecipesCarbon,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Todas las recetas",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = RecipesCarbon,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "${filteredRecipes.size} recetas",
                fontSize = 12.sp,
                color = RecipesGray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(filteredRecipes, key = { it.id }) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        onRecipeClick(recipe.id)
                    }
                )
            }

            if (filteredRecipes.isEmpty()) {
                item {
                    Text(
                        text = "No se han encontrado recetas.",
                        color = RecipesGray,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Row(
            modifier = Modifier.height(140.dp)
        ) {
            Image(
                painter = painterResource(recipe.image),
                contentDescription = recipe.name,
                modifier = Modifier
                    .width(125.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(13.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = recipe.category.uppercase(),
                    color = RecipesGreen,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = recipe.name,
                    color = RecipesCarbon,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 19.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${recipe.difficulty} · ${recipe.duration}",
                    color = RecipesGray,
                    fontSize = 11.sp
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = "Ver receta →",
                    color = RecipesOrange,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
