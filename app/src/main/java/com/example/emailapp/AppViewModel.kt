package com.example.emailapp

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.lifecycle.ViewModel
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.EmailType
import com.example.emailapp.data.dataclass.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState())

    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    fun initUIState() {
        _uiState.update {
            it.copy(
                currentWindowWidthSize = it.currentWindowWidthSize,
                isShowingHomeScreen = true,
                currentSelectedEmail = it.currentSelectedEmail,
                currentSelectedMailboxType = it.currentSelectedMailboxType
            )
        }
    }

    fun updateWindowWidthSize(windowSize: WindowWidthSizeClass) {
        _uiState.update {
            it.copy(
                currentWindowWidthSize = windowSize
            )
        }
    }

    fun onClickNavigationBarItem(mailboxType: EmailType) {
        _uiState.update {
            it.copy(
                currentSelectedMailboxType = mailboxType
            )
        }
    }

    fun onClickEmailCard(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail = email,
                isShowingHomeScreen = false
            )
        }
    }
}