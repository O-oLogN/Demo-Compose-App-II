package com.example.emailapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emailapp.R
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.EmailType
import com.example.emailapp.data.dataclass.Mailbox
import com.example.emailapp.data.dataclass.UIState

val navigationItemList: List<Mailbox> = listOf(
    Mailbox(
        icon = R.drawable.inbox,
        label = R.string.inbox,
        type = EmailType.Inbox
    ),
    Mailbox(
        icon = R.drawable.send,
        label = R.string.sent,
        type = EmailType.Sent
    ),
    Mailbox(
        icon = R.drawable.drafts,
        label = R.string.drafts,
        type = EmailType.Drafts
    ),
    Mailbox(
        icon = R.drawable.spam,
        label = R.string.spam,
        type = EmailType.Spam
    ),
)
@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    uiState: UIState = UIState(),
    onClickNavigationBarItem: (EmailType) -> Unit = {}
) {
    NavigationBar(
        containerColor = Color(0xFFE7E0CC),
        modifier = modifier
            .height(60.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                )
            ),
    ) {
        for (navItem in navigationItemList) {
            NavigationBarItem(
                selected = uiState.currentSelectedMailboxType == navItem.type,
                onClick = { onClickNavigationBarItem(navItem.type!!) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = null
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFE93D3D),
                    indicatorColor = Color(0xFFE7E0CC)
                ),
            )
        }
    }
}
@Composable
fun RailNavigationBar(
    uiState: UIState = UIState(),
    onClickNavigationBarItem: (EmailType) -> Unit = {},
) {
    NavigationRail(
        containerColor = Color(0xFFE7E0CC)
    ) {
        for (navItem in navigationItemList) {
            NavigationRailItem(
                selected = uiState.currentSelectedMailboxType == navItem.type,
                onClick = { onClickNavigationBarItem(navItem.type!!) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = null
                    )
                },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = Color(0xFFE93D3D),
                    indicatorColor = Color(0xFFE7E0CC)
                ),
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandingNavigationBar(
    uiState: UIState = UIState(),
    onClickNavigationBarItem: (EmailType) -> Unit = {}
) {
    Column(
        modifier = Modifier.background(Color(0xFFD3D8D2))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color(0xFF092075))
            )
            Spacer(modifier = Modifier.width(200.dp))
            Image(
                painter = painterResource(id = R.drawable.avatar_0),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(45.dp),
            )
        }
        PermanentDrawerSheet(
            drawerContainerColor = Color(0xFFD3D8D2)
        ) {
            for (navItem in navigationItemList) {
                NavigationDrawerItem(
                    selected = uiState.currentSelectedMailboxType == navItem.type,
                    icon = {
                        Icon(
                            painter = painterResource(id = navItem.icon),
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = navItem.label),
                            modifier = Modifier.padding(horizontal = 15.dp),
                        )
                    },
                    onClick = { onClickNavigationBarItem(navItem.type!!) },
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 5.dp,
                    ),
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent,
                        selectedContainerColor = Color(0xFF868B86)
                    )
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewNavigationBar() {
    RailNavigationBar()
}