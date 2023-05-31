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


@Composable
fun BottomNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarScreen.Product.route) {
            ProductScreen()
        }

        composable(route = BottomBarScreen.Cart.route) {
            CartScreen()
        }


        composable(route = BottomBarScreen.Setting.route) {
            SettingScreen()
        }
    }
}