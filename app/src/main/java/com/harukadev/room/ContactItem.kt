package com.harukadev.room

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ContactItem(modifier: Modifier = Modifier, contact: Contact, onEvent: (ContactEvent) -> Unit) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${contact.firstName} ${contact.lastName}",
                fontSize = 20.sp
            )
            Text(
                text = contact.phoneNumber,
                fontSize = 12.sp
            )
        }
        IconButton(onClick = {
            onEvent(ContactEvent.DeleteContact(contact))
        }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete contact"
            )
        }
    }
}

@Preview
@Composable
private fun ContactItemPreview() {
    MaterialTheme {
        ContactItem(
            contact = Contact(
                firstName = "haruka",
                lastName = "yamamoto",
                phoneNumber = "86999999999"
            ), onEvent = {}
        )
    }
}
