package com.example.emailapp.data.dataclass

import androidx.annotation.StringRes
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.emailapp.R

@Composable
fun Button(
    modifier: Modifier = Modifier,
    @StringRes content: Int,
    onClick: () -> Unit = {},
    fontColor: Color = Color.Black,
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(Color.Transparent)
) {
    OutlinedButton(
        onClick = onClick,
        shape = RectangleShape,
        modifier = modifier,
        colors = buttonColor
    ) {
        Text(
            text = stringResource(id = content),
            color = fontColor,
            fontWeight = FontWeight.Light
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    Button(content = R.string.reply)
}