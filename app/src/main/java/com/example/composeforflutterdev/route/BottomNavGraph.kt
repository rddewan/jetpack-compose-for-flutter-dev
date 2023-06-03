package com.example.composeforflutterdev.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composeforflutterdev.screens.CartScreen
import com.example.composeforflutterdev.screens.HomeScreen
import com.example.composeforflutterdev.screens.ProductDetailScreen
import com.example.composeforflutterdev.screens.ProductScreen
import com.example.composeforflutterdev.screens.SettingScreen
import com.example.composeforflutterdev.screens.auth.LoginScreen
import com.example.composeforflutterdev.screens.auth.RegisterScreen


fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(
        startDestination = "login",
        route = "auth"
    ) {

        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "register") {
            RegisterScreen(navController)
        }
    }
}

fun  NavGraphBuilder.mainGraph(navController: NavController) {

    navigation(
        startDestination = BottomBarScreen.Home.route,
        route = "main"
    ) {

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

@Composable
fun BottomNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "auth", //BottomBarScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {

        authGraph(navController)

        mainGraph(navController)

        composable(
            route = "product_detail/{productId}",
            arguments = listOf(navArgument("productId"){type = NavType.IntType})
        ) {
            ProductDetailScreen(
                navController,
                productId = it.arguments?.getInt("productId") ?: 1
            )
        }

    }
}