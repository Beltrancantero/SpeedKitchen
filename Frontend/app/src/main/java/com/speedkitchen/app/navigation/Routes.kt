
package com.speedkitchen.app.navigation

sealed class Routes(val route: String) {

    data object Welcome : Routes("welcome")

    data object Login : Routes("login")

    data object Register : Routes("register")

    data object Home : Routes("home")

    data object Recipes : Routes("recipes")

    data object RecipeDetail : Routes("recipe_detail/{recipeId}") {
        fun createRoute(recipeId: String): String {
            return "recipe_detail/$recipeId"
        }
    }

    data object Matches : Routes("matches")

    data object Profile : Routes("profile")

    data object Matchmaking : Routes("matchmaking")

    data object MatchLobby : Routes("match_lobby")
}
