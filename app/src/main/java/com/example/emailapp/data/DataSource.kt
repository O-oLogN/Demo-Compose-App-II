package com.example.emailapp.data

import com.example.emailapp.R
import com.example.emailapp.data.dataclass.Email
import com.example.emailapp.data.dataclass.EmailType

object DataSource {
    val emailList: List<Email> = listOf(
            Email(
                icon = R.drawable.avatar_express,
                sender = R.string.account_0_first_name,
                body = R.string.email_0_body,
                type = EmailType.Inbox,
                subject = R.string.email_0_subject,
                status = R.string.email_0_time
            ),
            Email(
                icon = R.drawable.avatar_1,
                sender = R.string.account_1_first_name,
                body = R.string.email_1_body,
                type = EmailType.Inbox,
                subject = R.string.email_1_subject,
                status = R.string.email_1_time
            ),
            Email(
                icon = R.drawable.avatar_2,
                sender = R.string.account_2_first_name,
                body = R.string.email_2_body,
                subject = R.string.email_2_subject,
                type = EmailType.Inbox,
                status = R.string.email_2_time
            ),
            Email(
                icon = R.drawable.avatar_3,
                sender = R.string.account_3_first_name,
                body = R.string.email_3_body,
                subject = R.string.email_3_subject,
                type = EmailType.Inbox,
                status = R.string.email_3_time
            ),
            Email(
                icon = R.drawable.avatar_4,
                sender = R.string.account_4_first_name,
                body = R.string.email_4_body,
                subject = R.string.email_4_subject,
                type = EmailType.Inbox,
                status = R.string.email_4_time
            ),
            Email(
                icon = R.drawable.avatar_5,
                sender = R.string.account_5_first_name,
                body = R.string.email_5_body,
                subject = R.string.email_5_subject,
                type = EmailType.Sent,
                status = R.string.email_5_time
            ),
            Email(
                icon = R.drawable.avatar_6,
                sender = R.string.account_6_first_name,
                body = R.string.email_6_body,
                subject = R.string.email_6_subject,
                type = EmailType.Sent,
                status = R.string.email_6_time
            ),
            Email(
                icon = R.drawable.avatar_7,
                sender = R.string.account_7_first_name,
                body = R.string.email_7_body,
                subject = R.string.email_7_subject,
                type = EmailType.Drafts,
                status = R.string.email_7_time
            ),
            Email(
                icon = R.drawable.avatar_8,
                sender = R.string.account_8_first_name,
                body = R.string.email_8_body,
                subject = R.string.email_8_subject,
                type = EmailType.Drafts,
                status = R.string.email_8_time
            ),
            Email(
                icon = R.drawable.avatar_9,
                sender = R.string.account_9_first_name,
                body = R.string.email_9_body,
                subject = R.string.email_9_subject,
                type = EmailType.Spam,
                status = R.string.email_9_time
            ),
            Email(
                icon = R.drawable.avatar_10,
                sender = R.string.account_10_first_name,
                body = R.string.email_10_body,
                subject = R.string.email_10_subject,
                type = EmailType.Spam,
                status = R.string.email_10_time
            ),
            Email(
                icon = R.drawable.avatar_11,
                sender = R.string.account_11_first_name,
                body = R.string.email_11_body,
                subject = R.string.email_11_subject,
                type = EmailType.Spam,
                status = R.string.email_11_time
            ),
        )
}
enum class ButtonContent {
    REPLIED, CONTINUED, DELETED
}