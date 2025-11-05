package com.example.lab_week_09

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun App(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "home"
    )
    {
        composable("home"){
            Home{ navController.navigate("resultContent/?listData=$it") }
        }
        composable(
            "resultContent/?listData={listData}",
            arguments = listOf(navArgument("listData"){
                type = NavType.StringType}
            )
        ) {
            ResultContent(
                it.arguments?.getString("listData").orEmpty()
            )
        }
    }
}