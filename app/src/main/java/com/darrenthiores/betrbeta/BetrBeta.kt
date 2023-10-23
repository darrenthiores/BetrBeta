package com.darrenthiores.betrbeta

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.darrenthiores.betrbeta.presentation.home.HomeScreen
import com.darrenthiores.betrbeta.presentation.home.HomeViewModel
import com.darrenthiores.betrbeta.utils.AppState
import com.darrenthiores.betrbeta.utils.TopLevelDestination
import com.darrenthiores.betrbeta.utils.rememberAppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BetrBeta(
    appState: AppState = rememberAppState()
) {
    val navController = appState.navController

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .padding(paddingValues),
            navController = navController,
            startDestination = TopLevelDestination.Home.name
        ) {
            composable(TopLevelDestination.Home.name) {
                val viewModel: HomeViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()

                HomeScreen(
                    state = state
                )
            }
        }
    }
}