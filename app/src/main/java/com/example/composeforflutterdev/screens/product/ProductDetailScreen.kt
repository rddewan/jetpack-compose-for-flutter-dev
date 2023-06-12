package com.example.composeforflutterdev.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composeforflutterdev.screens.product.data.ProductModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Int,
    product: ProductModel?
) {
    val canNavigateBack = navController.previousBackStackEntry != null

    var text by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar =  {
            TopAppBar(
                title = { Text(text = "Product Detail")},

                navigationIcon = {
                    if (canNavigateBack) {

                        navController.previousBackStackEntry?.savedStateHandle
                            ?.set("value",text)

                        IconButton(onClick = { navController.navigateUp()}) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    }
                },
            )
        },

    ) { paddingValue ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Product Detail")

            Text(text = "ProductId: $productId")

            if (product != null) {
                Text(text = "Id: ${product.id}")
                Text(text = "Id: ${product.name}")
                Text(text = "Id: ${product.description}")
            }

            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                }
            )

        }

    }
}