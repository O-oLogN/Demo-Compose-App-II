package com.example.emailapp.data

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emailapp.R
import com.example.emailapp.data.dataclass.Button
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.EmailType
import com.example.emailapp.data.dataclass.UIState

@Composable
fun DisplayDetailEmail(
    onClickBackButton: () -> Unit = {},
    uiState: UIState = UIState(),
    context: Context = LocalContext.current
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECECEC))
    ) {
        when (uiState.currentWindowWidthSize) {
            WindowWidthSizeClass.Compact, WindowWidthSizeClass.Expanded -> {
                if (uiState.currentWindowWidthSize == WindowWidthSizeClass.Compact) {
                    TopBar(
                        email = uiState.currentSelectedEmail,
                        onClickBackButton = onClickBackButton,
                    )
                }
                EmailHeader(
                    email = uiState.currentSelectedEmail,
                    modifier = Modifier.padding(
                        start = 30.dp,
                        bottom = 10.dp,
                        top = 10.dp
                    )
                )
                DetailsScreen(
                    email = uiState.currentSelectedEmail,
                    context = context
                )
            }
            else -> {
                Column {
                    TopBar(
                        email = uiState.currentSelectedEmail,
                        onClickBackButton = onClickBackButton
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SideBar(email = uiState.currentSelectedEmail)
                        DetailsScreen(
                            email = uiState.currentSelectedEmail,
                            context = context
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun SideBar(email: Email) {
    Row(
        modifier = Modifier.fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = email.icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .clip(CircleShape)
                    .size(120.dp)
            )
            Text(
                text = stringResource(id = email.sender),
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 3.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = email.status),
                fontWeight = FontWeight.Light,
                fontSize = 15.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
@Composable
fun DetailsScreen(
    email: Email,
    context: Context
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        BodyEmail(email = email)
        Spacer(modifier = Modifier.height(100.dp))
        when (email.type) {
            EmailType.Sent, EmailType.Inbox -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(35.dp))
                    Button(
                        content = R.string.reply,
                        onClick = {
                            displayAndroidMessage(
                                message = ButtonContent.REPLIED.name,
                                context = context
                            )
                        },
                        modifier = Modifier.width(120.dp)
                    )
                    Spacer(modifier = Modifier.width(80.dp))
                    Button(
                        content = R.string.reply_all,
                        onClick = {
                            displayAndroidMessage(
                                message = ButtonContent.REPLIED.name,
                                context = context
                            )
                        },
                        modifier = Modifier.width(120.dp)
                    )
                }
            }
            EmailType.Spam -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(35.dp))
                    Button(
                        content = R.string.reply,
                        onClick = {
                            displayAndroidMessage(
                                message = ButtonContent.REPLIED.name,
                                context = context
                            )
                        },
                        modifier = Modifier.width(120.dp)
                    )
                    Spacer(modifier = Modifier.width(80.dp))
                    Button(
                        content = R.string.delete,
                        onClick = {
                            displayAndroidMessage(
                                message = ButtonContent.DELETED.name,
                                context = context
                            )
                        },
                        fontColor = Color.White,
                        buttonColor = ButtonDefaults.buttonColors(Color(0xFF413F3F)),
                        modifier = Modifier.width(120.dp)
                    )
                }
            }
            else -> {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        content = R.string.continue_composing,
                        onClick = {
                            displayAndroidMessage(
                                message = ButtonContent.CONTINUED.name,
                                context = context
                            )
                        },
                        fontColor = Color.White,
                        buttonColor = ButtonDefaults.buttonColors(Color(0xFF413F3F)),
                        modifier = Modifier.width(200.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun TopBar(
    email: Email,
    onClickBackButton: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onClickBackButton,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.Filled.ArrowBack),
                contentDescription = null,
                tint = Color(0xFFB8B0B0)
            )
        }
        Text(
            text = stringResource(id = email.subject),
            color = Color(0xFF6B6868),
            fontSize = 21.sp,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 10.dp)
        )
    }
}
@Composable
fun BodyEmail(email: Email) {
    Text(
        text = stringResource(id = email.body).ifEmpty { stringResource(id = R.string.empty) },
        fontSize = 15.sp,
        modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 5.dp, bottom = 10.dp)
    )
}
private fun displayAndroidMessage(message: String, context: Context) {
    Toast.makeText(context, message, LENGTH_SHORT).show()
}
@Preview(showBackground = true)
@Composable
fun PreviewDetailEmail() {
    DisplayDetailEmail()
}

