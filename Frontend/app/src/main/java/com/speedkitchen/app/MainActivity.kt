
package com.speedkitchen.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.speedkitchen.app.ui.theme.SpeedKitchenTheme
import com.speedkitchen.app.navigation.AppNavigation
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SpeedKitchenTheme {
                AppNavigation()
            }
        }
    }
}
