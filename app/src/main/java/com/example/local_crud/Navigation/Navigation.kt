package com.example.local_crud.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.local_crud.screen.AddScreen
import com.example.local_crud.screen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home.screen) {
        composable(Route.Home.screen) {
            HomeScreen(navController)
        }

        composable(Route.Add.screen) {
            AddScreen(navController)
        }

        composable(Route.Edit.screen) {

        }
    }
}