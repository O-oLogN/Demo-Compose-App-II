package com.example.emailapp.data.dataclass

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Mailbox(
    @DrawableRes val icon: Int = 0,
    @StringRes val label: Int = 0,
    val type: EmailType? = null
)
