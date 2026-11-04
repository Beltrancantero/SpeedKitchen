
package com.speedkitchen.app.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Orange = Color(0xFFFF7733)
private val Carbon = Color(0xFF202321)
private val Cream = Color(0xFFFFF8EF)

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    NavigationBar(
        containerColor = Carbon,
        contentColor = Cream
    ) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            icon = { Text("⌂") },
            label = { Text("Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Orange,
                selectedTextColor = Orange,
                indicatorColor = Color(0xFF35312D),
                unselectedIconColor = Cream,
                unselectedTextColor = Cream
            )
        )

        NavigationBarItem(
            selected = currentRoute == "recipes",
            onClick = { onNavigate("recipes") },
            icon = { Text("▤") },
            label = { Text("Recetas") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Orange,
                selectedTextColor = Orange,
                indicatorColor = Color(0xFF35312D),
                unselectedIconColor = Cream,
                unselectedTextColor = Cream
            )
        )

        NavigationBarItem(
            selected = currentRoute == "matches",
            onClick = { onNavigate("matches") },
            icon = { Text("⚔") },
            label = { Text("Partidas") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Orange,
                selectedTextColor = Orange,
                indicatorColor = Color(0xFF35312D),
                unselectedIconColor = Cream,
                unselectedTextColor = Cream
            )
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { onNavigate("profile") },
            icon = { Text("●") },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Orange,
                selectedTextColor = Orange,
                indicatorColor = Color(0xFF35312D),
                unselectedIconColor = Cream,
                unselectedTextColor = Cream
            )
        )
    }
}
