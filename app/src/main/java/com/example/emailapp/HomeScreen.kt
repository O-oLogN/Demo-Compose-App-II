package com.example.emailapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emailapp.data.BottomNavigationBar
import com.example.emailapp.data.DataSource
import com.example.emailapp.data.DisplayDetailEmail
import com.example.emailapp.data.DisplayEmailList
import com.example.emailapp.data.ExpandingNavigationBar
import com.example.emailapp.data.RailNavigationBar
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.EmailType
import com.example.emailapp.data.dataclass.UIState

@Composable
fun HomeScreen(
    uiState: UIState = UIState(),
    onClickEmailCard: (Email) -> Unit = {},
    onClickNavigationBarItem: (EmailType) -> Unit = {},
    onClickBackButton: () -> Unit = {}
) {
    when (uiState.currentWindowWidthSize) {
        WindowWidthSizeClass.Compact -> {
            if (uiState.isShowingHomeScreen) {
                Box {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color(0xFF19998B))
                            )
                            Spacer(modifier = Modifier.width(250.dp))
                            Image(
                                painter = painterResource(id = R.drawable.avatar_0),
                                contentDescription = null,
                                modifier = Modifier.clip(CircleShape),
                            )
                        }
                        DisplayEmailList(
                            emailList = DataSource.emailList,
                            uiState = uiState,
                            onClickEmailCard = { onClickEmailCard(it) },
                            modifier = Modifier.width(700.dp)
                        )
                    }
                    BottomNavigationBar(
                        uiState = uiState,
                        onClickNavigationBarItem = { onClickNavigationBarItem(it) },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )
                }
            }
            else {
                DisplayDetailEmail(
                    uiState = uiState,
                    onClickBackButton = onClickBackButton
                )
            }
        }
        WindowWidthSizeClass.Medium -> {
            if (uiState.isShowingHomeScreen) {
                Row {
                    RailNavigationBar(
                        uiState = uiState,
                        onClickNavigationBarItem = { onClickNavigationBarItem(it) }
                    )
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color(0xFF19998B))
                            )
                            Spacer(modifier = Modifier.width(400.dp))
                            Image(
                                painter = painterResource(id = R.drawable.avatar_0),
                                contentDescription = null,
                                modifier = Modifier.clip(CircleShape),
                            )
                        }
                        DisplayEmailList(
                            emailList = DataSource.emailList,
                            uiState = uiState,
                            onClickEmailCard = { onClickEmailCard(it) },
                            modifier = Modifier.width(700.dp)
                        )
                    }
                }
            }
            else {
                DisplayDetailEmail(
                    uiState = uiState,
                    onClickBackButton = onClickBackButton
                )
            }
        }
        else -> {
            Row {
                ExpandingNavigationBar(
                    uiState = uiState,
                    onClickNavigationBarItem = { onClickNavigationBarItem(it) },
                )
                DisplayEmailList(
                    emailList = DataSource.emailList,
                    uiState = uiState,
                    onClickEmailCard = { onClickEmailCard(it) },
                    modifier = Modifier.width(520.dp)
                )
                DisplayDetailEmail(uiState = uiState)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}