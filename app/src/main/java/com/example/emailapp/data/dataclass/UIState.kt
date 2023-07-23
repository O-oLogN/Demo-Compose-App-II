package com.example.emailapp.data.dataclass

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.example.emailapp.data.DataSource

data class UIState(
    val currentWindowWidthSize: WindowWidthSizeClass? = null,
    val currentSelectedEmail: Email = DataSource.emailList[0],
    val currentSelectedMailboxType: EmailType = EmailType.Inbox,
    val isShowingHomeScreen: Boolean = true
)