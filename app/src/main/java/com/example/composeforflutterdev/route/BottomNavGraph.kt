package com.example.composeforflutterdev.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
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
import com.example.composeforflutterdev.screens.product.data.ProductModel
import com.example.composeforflutterdev.viewmodel.SettingViewModel
import com.example.composeforflutterdev.viewmodel.SharedProductViewModel


fun NavGraphBuilder.authGraph(navController: NavHostController) {
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

fun  NavGraphBuilder.mainGraph(navController: NavHostController) {

    navigation(
        startDestination = BottomBarScreen.Home.route,
        route = "main"
    ) {

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }


        composable(route = BottomBarScreen.Cart.route) {
            CartScreen(navController)
        }

        productGraph(navController)

        composable(route = BottomBarScreen.Setting.route) {
            //val viewModel = SettingViewModel()
            //val viewModel = viewModel<SettingViewModel>()
            val viewModel = viewModel<SettingViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return SettingViewModel(themeMode = "dark") as T
                    }
                }
            )
            SettingScreen(navController, viewModel = viewModel)
        }

    }
}

fun NavGraphBuilder.productGraph(navController: NavHostController) {
    navigation(
        startDestination = BottomBarScreen.Product.route,
        route = "products"
    ) {

        composable(route = BottomBarScreen.Product.route) {
            val viewModel = it.sharedViewModel<SharedProductViewModel>(navController = navController)
            ProductScreen(navController, viewModel)
        }

        composable(
            route = "product_detail/{productId}",
            arguments = listOf(navArgument("productId"){type = NavType.IntType})
        ) {
            //val product = it.savedStateHandle.get<ProductModel>("product")

            val viewModel = it.sharedViewModel<SharedProductViewModel>(navController = navController)

            val product = navController
                .previousBackStackEntry
                ?.savedStateHandle?.get<ProductModel>("product")

            ProductDetailScreen(
                navController,
                productId = it.arguments?.getInt("productId") ?: 1,
                product = product,
                viewModel
            )
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


    }
}

// shared view model extensions
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    // get the current nestedNavGraph parent route and if null return the new view model instance
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    // when nav back entry change get the NavBackStackEntry of Nested NavGraph
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    // returns a view model with  NavBackStackEntry
    // scoped view model to the parent NavBackStackEntry
    return viewModel(parentEntry)
}