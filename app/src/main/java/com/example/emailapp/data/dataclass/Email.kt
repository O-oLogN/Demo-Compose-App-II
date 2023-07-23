package com.example.emailapp.data.dataclass

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Email(
    @DrawableRes val icon: Int = 0,
    @StringRes val sender: Int = 0,
    @StringRes val status: Int = 0,
    @StringRes val subject: Int = 0,
    @StringRes val body: Int = 0,
    val type: EmailType? = null
)
enum class EmailType {
    Sent, Inbox, Spam, Drafts
}