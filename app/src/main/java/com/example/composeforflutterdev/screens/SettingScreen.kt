package com.example.composeforflutterdev.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeforflutterdev.ui.theme.AppTheme
import com.example.composeforflutterdev.viewmodel.SettingViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavController, viewModel: SettingViewModel) {
    AppTheme(viewModel.theme == "dark") {
        Scaffold(
            topBar =  {
                TopAppBar(
                    title = { Text(text = "Home")},

                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Home Menu Icon")
                        }
                    },

                    actions =  {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Menu Icon")
                        }
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Info, contentDescription = "Info Menu Icon")
                        }

                    }
                )

            },
            bottomBar = {
                BottomBar(navController = navController)
            }

        ) { paddingValue ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Setting")

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {
                        navController.navigate("auth") {
                            popUpTo("main") {
                                inclusive = true
                            }
                        }
                    }) {
                    Text(text = "LogOut")
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {
                        viewModel.changeTheme()
                    }) {
                    Text(text = "Change Theme")
                }

            }

        }

    }

}