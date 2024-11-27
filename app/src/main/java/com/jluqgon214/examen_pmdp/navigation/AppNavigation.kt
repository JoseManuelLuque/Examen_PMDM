package com.jluqgon214.examen_pmdp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.examen_pmdp.data.viewModel
import com.jluqgon214.examen_pmdp.screens.MainScreen
import com.jluqgon214.examen_pmdp.screens.SecondScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val viewModel: viewModel = viewModel()

    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController, viewModel)
        }
        composable("SecondScreen") {
            SecondScreen(navController, viewModel)
        }
    }
}