package com.tkmonkey.contactsappkmm.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tkmonkey.contactsappkmm.ui.DarkColorScheme
import com.tkmonkey.contactsappkmm.ui.LightColorScheme
import com.tkmonkey.contactsappkmm.ui.Typography

@Composable
actual fun ContactsTheme(
	darkTheme: Boolean,
	dynamicColor: Boolean,
	content: @Composable () -> Unit
) {
	MaterialTheme(
		colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
		typography = Typography,
		content = content
	)
}