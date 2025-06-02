package com.example.fetchrewards.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fetchrewards.screens.HiringItemScreen
import com.example.fetchrewards.screens.HiringScreen
import com.example.fetchrewards.screens.SettingsScreen
import kotlinx.serialization.Serializable
/*

@Composable
fun HiringNavGraph(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = HiringListRoute) {
        composable<HiringListRoute> {
            HiringScreen(
                Modifier.padding(paddingValues),
                onNavigateToItem = {
                    navigateToHiringItem(navController, it)
                }
            )
        }
        composable<HiringItemRoute> { backStackEntry ->
            val hiringItemRoute: HiringItemRoute = backStackEntry.toRoute()
            HiringItemScreen(hiringItemRoute, navController)
        }
    }
}
*/


@Serializable
object HiringNavGraph

@Serializable
object HiringListRoute

@Serializable
data class HiringItemRoute(val itemId: Int)


fun NavGraphBuilder.hiringNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    navigation<HiringNavGraph>(startDestination = HiringListRoute) {
        composable<HiringListRoute> {
            HiringScreen(
                Modifier.padding(paddingValues),
                onNavigateToItem = {
                    navController.navigateToItemScreen(navController, it)
                }
            )
        }
        hiringItemGraph(navController)

    }
}

fun NavController.navigateToItemScreen(navController: NavHostController, i: Int) {
    navController.navigate(route = HiringItemRoute(i))
}

fun NavGraphBuilder.hiringItemGraph(navController: NavController) {
    composable<HiringItemRoute> { backStackEntry ->
        val hiringItemRoute: HiringItemRoute = backStackEntry.toRoute()
        HiringItemScreen(hiringItemRoute, navController)
    }
}


