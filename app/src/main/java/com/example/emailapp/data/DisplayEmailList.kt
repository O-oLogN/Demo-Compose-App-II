package com.example.emailapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.UIState

@Composable
fun DisplayEmailList(
    modifier: Modifier = Modifier,
    emailList: List<Email>,
    uiState: UIState = UIState(),
    onClickEmailCard: (Email) -> Unit = {}
) {
    Column {
        LazyColumn {
            items(emailList) { email ->
                if (email.type == uiState.currentSelectedMailboxType) {
                    EmailCard(
                        email = email,
                        selected = uiState.currentSelectedEmail == email,
                        onClickEmailCard = { onClickEmailCard(email) },
                        modifier = modifier
                    )
                }
            }
        }
    }
}
@Composable
fun EmailCard(
    modifier: Modifier = Modifier,
    email: Email,
    onClickEmailCard : (Email) -> Unit = {},
    selected: Boolean = false
) {
    Surface(
        modifier = modifier
            .height(150.dp)
            .selectable(
                selected = selected,
                onClick = { onClickEmailCard(email) }
            )
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp)),
        color = if(!selected) Color.Transparent
                else Color(0xFFCBECDE),
        shadowElevation = 3.dp,
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            EmailHeader(email = email)
            Text(
                text = stringResource(id = email.subject),
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Text(
                text = stringResource(id = email.body),
                fontSize = 11.sp,
                color = Color(0xFF6B6868),
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }
    }
}
@Composable
fun EmailHeader(
    modifier: Modifier = Modifier,
    email: Email
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = email.icon),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp),
            )
        }
        Column(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Text(
                text = stringResource(id = email.sender),
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 5.dp),
            )
            Text(
                text = stringResource(id = email.status),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xE89C9292),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewEmailCard() {
    EmailCard(email = DataSource.emailList[1])
}