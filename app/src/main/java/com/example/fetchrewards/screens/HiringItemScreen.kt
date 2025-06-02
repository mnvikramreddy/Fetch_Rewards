package com.example.fetchrewards.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.fetchrewards.navigation.HiringItemRoute
import com.example.fetchrewards.navigation.HiringListRoute
import com.example.fetchrewards.viewmodels.HiringViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun HiringItemScreen(hiringItemRoute: HiringItemRoute, navController: NavController) {

    val parentEntry = remember { navController.getBackStackEntry(HiringListRoute) }
    val viewModel = hiltViewModel<HiringViewModel>(parentEntry)

    Log.d(" HIRING ITEEM VIEWMODEL" , "${viewModel}")
    val itemDetails = viewModel.getItemDetails(hiringItemRoute.itemId)
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = """We entered the item details with id = ${itemDetails?.id}
                | item list id = ${itemDetails?.listId}
                | item name = ${itemDetails?.name}
            """.trimMargin()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun itemPreview(){
   // HiringItemScreen(hiringItemRoute = HiringItemRoute(1), navController = NavController)
}