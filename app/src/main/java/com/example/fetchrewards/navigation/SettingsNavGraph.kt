package com.example.fetchrewards.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.fetchrewards.screens.SettingsScreen
import kotlinx.serialization.Serializable


@Serializable
object SettingsGraph

@Serializable
object SettingsRoute

fun NavGraphBuilder.settingsGraph() {
    navigation<SettingsGraph>(startDestination = SettingsRoute) {
        composable<SettingsRoute> {
            SettingsScreen()
        }
    }
}