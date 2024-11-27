package com.jluqgon214.examen_pmdp.navigation

sealed class AppScreen(val route: String) {
    object MainScreen: AppScreen("MainScreen")
    object SecondScreen: AppScreen("SecondScreen")
}