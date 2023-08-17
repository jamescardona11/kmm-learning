package com.tkmonkey.contactsappkmm.contacts.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tkmonkey.contactsappkmm.contacts.domain.Contact

@Composable
fun ContactPhoto(
	contact: Contact?,
	modifier: Modifier = Modifier,
	iconSize: Dp = 25.dp
) {
	if(contact?.photosByte != null) {

	}

}