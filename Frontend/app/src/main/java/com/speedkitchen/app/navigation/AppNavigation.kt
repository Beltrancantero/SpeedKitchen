
package com.speedkitchen.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.speedkitchen.app.PantallaBienvenida
import com.speedkitchen.app.ui.components.BottomNavigationBar
import com.speedkitchen.app.ui.screens.HomeScreen
import com.speedkitchen.app.ui.screens.LoginScreen
import com.speedkitchen.app.ui.screens.RegisterScreen
import com.speedkitchen.app.ui.screens.RecipeDetailsScreen
import com.speedkitchen.app.ui.screens.RecipesScreen
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.speedkitchen.app.ui.screens.MatchesScreen
import kotlin.collections.*
import com.speedkitchen.app.ui.screens.MatchmakingScreen
import com.speedkitchen.app.ui.screens.MatchLobbyScreen
import com.speedkitchen.app.ui.screens.ProfileScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    val showBottomBar =
        currentRoute == Routes.Home.route ||
                currentRoute == Routes.Recipes.route ||
                currentRoute == Routes.Matches.route ||
                currentRoute == Routes.Profile.route

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    currentRoute = currentRoute ?: Routes.Home.route,
                    onNavigate = { route ->

                        navController.navigate(route) {
                            popUpTo(Routes.Home.route) {
                                inclusive = false
                            }

                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            NavHost(
                navController = navController,
                startDestination = Routes.Welcome.route
            ) {

                // BIENVENIDA
                composable(Routes.Welcome.route) {
                    PantallaBienvenida(
                        onStartClick = {
                            navController.navigate(Routes.Login.route)
                        }
                    )
                }

                // LOGIN
                composable(Routes.Login.route) {
                    LoginScreen(
                        onLoginClick = { email, password ->
                            // Pendiente: conectar con el backend.
                        },

                        onRegisterClick = {
                            navController.navigate(Routes.Register.route)
                        },

                        onForgotPasswordClick = {
                            // Pendiente: recuperación de contraseña.
                        },

                        onGuestClick = {
                            navController.navigate(Routes.Home.route) {
                                popUpTo(Routes.Welcome.route) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                // REGISTRO
                composable(Routes.Register.route) {
                    RegisterScreen(
                        onRegisterClick = { username, email, password ->
                            // Pendiente: conectar con el backend.
                        },

                        onLoginClick = {
                            navController.popBackStack()
                        }
                    )
                }

                // INICIO
                composable(Routes.Home.route) {
                    HomeScreen(
                        onRecipesClick = {
                            navController.navigate(Routes.Recipes.route)
                        },

                        onMatchesClick = {
                            navController.navigate(Routes.Matches.route)
                        },

                        onProfileClick = {
                            navController.navigate(Routes.Profile.route)
                        }
                    )
                }
                composable(Routes.Recipes.route) {
                    RecipesScreen(
                        onRecipeClick = { recipeId ->
                            navController.navigate(
                                Routes.RecipeDetail.createRoute(recipeId)
                            )
                        }
                    )
                }

                // PARTIDAS
                composable(Routes.Matches.route) {
                    MatchesScreen(
                        onQuickMatchClick = {
                            // Pendiente de conectar con el backend.
                        },
                        onInviteClick = {
                            // Pendiente de conectar con el backend.
                        }
                    )
                }

                composable(Routes.Matchmaking.route) {
                    MatchmakingScreen(
                        onCancelClick = {
                            navController.popBackStack()
                        },
                        onMatchFoundClick = {
                            navController.navigate(Routes.MatchLobby.route)
                        }
                    )
                }

                composable(Routes.Matchmaking.route) {
                    MatchmakingScreen(
                        onCancelClick = {
                            navController.popBackStack()
                        },
                        onMatchFoundClick = {
                            navController.navigate(Routes.MatchLobby.route)
                        }
                    )
                }

                composable(Routes.MatchLobby.route) {
                    MatchLobbyScreen(
                        onBackClick = {
                            navController.popBackStack()
                        },
                        onPrepareClick = {
                            navController.navigate(Routes.Recipes.route)
                        }
                    )
                }

                // PERFIL
                composable(Routes.Profile.route) {
                    ProfileScreen()
                }

                // DETALLE DE RECETA
                composable(
                    route = Routes.RecipeDetail.route,
                    arguments = listOf(
                        navArgument("recipeId") {
                            type = NavType.StringType
                        }
                    )
                ) { backStackEntry ->

                    val recipeId = backStackEntry.arguments
                        ?.getString("recipeId") ?: "pasta"

                    RecipeDetailsScreen(
                        recipeId = recipeId,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
