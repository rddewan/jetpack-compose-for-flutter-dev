package com.example.composeforflutterdev.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeforflutterdev.route.BottomNavGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add")},
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                onClick =  {

                }
            )
        }

    ) { paddingValue ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValue),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card (
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .clickable {

                    }
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "person icon")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Richard Dewan",
                            style = MaterialTheme.typography.headlineSmall
                        )

                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "This ia a user card from Richard. Just a simple card",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Jetpack Compose is Android's recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs. View tutorial View docs. Less code Do more with less code and avoid entire classes of bugs, so code is simple and",
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }

            }



        }

    }

}