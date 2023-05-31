package com.example.composeforflutterdev.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeforflutterdev.screens.CartScreen
import com.example.composeforflutterdev.screens.HomeScreen
import com.example.composeforflutterdev.screens.ProductScreen
import com.example.composeforflutterdev.screens.SettingScreen
import com.example.composeforflutterdev.screens.auth.LoginScreen
import com.example.composeforflutterdev.screens.auth.RegisterScreen


@Composable
fun BottomNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "login", //BottomBarScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {

        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "register") {
            RegisterScreen(navController)
        }



        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }

        composable(route = BottomBarScreen.Product.route) {
            ProductScreen(navController)
        }

        composable(route = BottomBarScreen.Cart.route) {
            CartScreen(navController)
        }


        composable(route = BottomBarScreen.Setting.route) {
            SettingScreen(navController)
        }
    }
}