package com.tkmonkey.contactsappkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.tkmonkey.contactsappkmm.App

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			App (
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true
            )
		}
	}
}
