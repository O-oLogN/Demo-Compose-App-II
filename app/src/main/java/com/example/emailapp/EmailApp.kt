package com.example.emailapp

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EmailApp(
    windowSize: WindowWidthSizeClass,
) {
    val appViewModel: AppViewModel = viewModel()
    val uiState by appViewModel.uiState.collectAsState()
    when (windowSize) {
        WindowWidthSizeClass.Compact ->
            appViewModel.updateWindowWidthSize(WindowWidthSizeClass.Compact)
        WindowWidthSizeClass.Medium ->
            appViewModel.updateWindowWidthSize(WindowWidthSizeClass.Medium)
        else ->
            appViewModel.updateWindowWidthSize(WindowWidthSizeClass.Expanded)
    }
    HomeScreen(
        uiState = uiState,
        onClickNavigationBarItem = { appViewModel.onClickNavigationBarItem(it) },
        onClickEmailCard = { appViewModel.onClickEmailCard(it) },
        onClickBackButton = { appViewModel.initUIState() }
    )
}