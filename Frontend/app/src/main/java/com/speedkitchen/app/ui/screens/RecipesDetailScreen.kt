
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

private val DetailCream = Color(0xFFFFF8EF)
private val DetailOrange = Color(0xFFF36F38)
private val DetailCarbon = Color(0xFF292824)
private val DetailGray = Color(0xFF77716A)
private val DetailGreen = Color(0xFF78866B)

private data class RecipeInfo(
    val name: String,
    val description: String,
    val category: String,
    val difficulty: String,
    val duration: String,
    val portions: String,
    val image: Int,
    val ingredients: List<String>,
    val steps: List<String>,
    val tip: String
)

private fun getRecipe(recipeId: String): RecipeInfo {
    return when (recipeId) {
        "pollo" -> RecipeInfo(
            name = "Pollo salteado con verduras",
            description = "Pollo dorado acompañado de verduras salteadas. Una receta equilibrada y llena de sabor.",
            category = "CARNES",
            difficulty = "Media",
            duration = "40 min",
            portions = "2",
            image = R.drawable.home_chef,
            ingredients = listOf(
                "300 g de pechuga de pollo",
                "1 pimiento rojo",
                "1 zanahoria",
                "1/2 cebolla",
                "1 diente de ajo",
                "2 cucharadas de aceite de oliva",
                "Sal y pimienta"
            ),
            steps = listOf(
                "Cortar el pollo en tiras de tamaño parecido.",
                "Lavar y cortar el pimiento, la zanahoria y la cebolla.",
                "Calentar el aceite en una sartén y dorar el pollo.",
                "Retirar el pollo y saltear las verduras hasta que estén tiernas.",
                "Añadir de nuevo el pollo y el ajo picado. Cocinar hasta que el pollo esté completamente hecho.",
                "Rectificar de sal y pimienta y servir."
            ),
            tip = "Corta todos los ingredientes antes de empezar. Así podrás cocinar sin interrupciones."
        )

        "salmon" -> RecipeInfo(
            name = "Salmón con verduras",
            description = "Salmón cocinado a la plancha con una guarnición de verduras. Una combinación sencilla y sabrosa.",
            category = "PESCADOS",
            difficulty = "Fácil",
            duration = "30 min",
            portions = "2",
            image = R.drawable.fresh_ingredients,
            ingredients = listOf(
                "2 lomos de salmón",
                "1 calabacín",
                "1 zanahoria",
                "1/2 limón",
                "2 cucharadas de aceite de oliva",
                "Sal y pimienta"
            ),
            steps = listOf(
                "Lavar el calabacín y la zanahoria.",
                "Cortar las verduras en rodajas finas.",
                "Saltear las verduras con un poco de aceite hasta que estén tiernas.",
                "Calentar otra sartén y cocinar el salmón por ambos lados.",
                "Comprobar que el centro del pescado esté completamente cocinado.",
                "Servir el salmón con las verduras y unas gotas de limón."
            ),
            tip = "Seca el salmón con papel de cocina antes de cocinarlo para favorecer el dorado."
        )

        "tarta" -> RecipeInfo(
            name = "Tarta de chocolate",
            description = "Una tarta de chocolate esponjosa y deliciosa, perfecta para terminar una comida.",
            category = "POSTRES",
            difficulty = "Difícil",
            duration = "50 min",
            portions = "6",
            image = R.drawable.cooking_chef,
            ingredients = listOf(
                "150 g de chocolate negro",
                "100 g de mantequilla",
                "100 g de azúcar",
                "2 huevos",
                "80 g de harina",
                "1 cucharadita de levadura química"
            ),
            steps = listOf(
                "Precalentar el horno a 180 °C.",
                "Fundir el chocolate junto con la mantequilla.",
                "Batir los huevos con el azúcar hasta obtener una mezcla homogénea.",
                "Incorporar el chocolate fundido y mezclar.",
                "Añadir la harina y la levadura tamizadas.",
                "Verter la mezcla en un molde engrasado.",
                "Hornear aproximadamente 25-30 minutos y dejar enfriar antes de servir."
            ),
            tip = "No abras el horno continuamente durante la cocción. Comprueba el punto con un palillo."
        )

        else -> RecipeInfo(
            name = "Pasta cremosa con tomate y parmesano",
            description = "Una pasta cremosa con tomate, ajo y queso parmesano. Un plato sencillo para demostrar tu técnica en la cocina.",
            category = "PASTA",
            difficulty = "Fácil",
            duration = "25 min",
            portions = "2",
            image = R.drawable.recipe_pasta,
            ingredients = listOf(
                "200 g de pasta",
                "150 g de tomate triturado",
                "1 diente de ajo",
                "50 ml de nata para cocinar",
                "30 g de queso parmesano",
                "1 cucharada de aceite de oliva",
                "Sal y pimienta al gusto"
            ),
            steps = listOf(
                "Preparar los ingredientes: pelar y picar el ajo. Tener a mano el tomate, la nata y el parmesano.",
                "Cocer la pasta en agua con sal siguiendo el tiempo indicado en el paquete.",
                "Calentar el aceite en una sartén y sofreír el ajo. Añadir el tomate triturado.",
                "Incorporar la nata y dejar que la salsa reduzca ligeramente.",
                "Añadir la pasta escurrida a la sartén y mezclar para integrar la salsa.",
                "Emplatar y terminar con parmesano rallado y pimienta."
            ),
            tip = "Reserva un poco de agua de cocción de la pasta para conseguir una salsa más cremosa."
        )
    }
}

@Composable
fun RecipeDetailsScreen(
    recipeId: String,
    onBackClick: () -> Unit
) {
    val recipe = getRecipe(recipeId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DetailCream)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            // IMAGEN PRINCIPAL
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            ) {
                Image(
                    painter = painterResource(recipe.image),
                    contentDescription = recipe.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0x55000000),
                                    Color.Transparent,
                                    Color(0x99000000)
                                )
                            )
                        )
                )

                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .padding(18.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopStart)
                ) {
                    Text(
                        text = "‹",
                        fontSize = 30.sp,
                        color = DetailCarbon
                    )
                }

                Text(
                    text = recipe.category,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp)
                )
            }

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = recipe.name,
                    fontSize = 27.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight.Black,
                    color = DetailCarbon
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = recipe.description,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    color = DetailGray
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    InfoCard(recipe.duration, "TIEMPO")
                    InfoCard(recipe.difficulty, "DIFICULTAD")
                    InfoCard(recipe.portions, "RACIONES")
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Ingredientes",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DetailCarbon
                )

                Text(
                    text = "Para ${recipe.portions} personas",
                    fontSize = 13.sp,
                    color = DetailGray
                )

                Spacer(modifier = Modifier.height(14.dp))

                recipe.ingredients.forEach { ingredient ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .clip(CircleShape)
                                .background(DetailOrange)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = ingredient,
                            fontSize = 14.sp,
                            color = DetailCarbon
                        )
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                HorizontalDivider(color = Color(0xFFE5DDD3))

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "Preparación",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = DetailCarbon
                )

                Spacer(modifier = Modifier.height(15.dp))

                recipe.steps.forEachIndexed { index, step ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(DetailOrange),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${index + 1}",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            text = step,
                            modifier = Modifier.weight(1f),
                            color = DetailCarbon,
                            fontSize = 14.sp,
                            lineHeight = 21.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "CONSEJO DEL CHEF",
                            color = DetailGreen,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(7.dp))

                        Text(
                            text = recipe.tip,
                            color = DetailCarbon,
                            fontSize = 13.sp,
                            lineHeight = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))
            }
        }

        Surface(
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Text(
                text = "SPEED KITCHEN · RECETAS",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                color = DetailGray,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun RowScope.InfoCard(
    value: String,
    label: String
) {
    Card(
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = DetailOrange
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = DetailGray
            )
        }
    }
}
