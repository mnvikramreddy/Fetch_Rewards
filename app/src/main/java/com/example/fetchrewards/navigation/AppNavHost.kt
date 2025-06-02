package com.example.fetchrewards.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute("Hiring", HiringNavGraph, Icons.Default.AccountCircle),
    TopLevelRoute("settings", SettingsGraph, Icons.Default.Settings)
)

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = HiringNavGraph) {
        hiringNavGraph(navController, paddingValues)
        settingsGraph()
    }
}