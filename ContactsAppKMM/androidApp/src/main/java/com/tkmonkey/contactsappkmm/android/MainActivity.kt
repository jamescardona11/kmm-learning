package com.tkmonkey.contactsappkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalContext
import com.tkmonkey.contactsappkmm.App
import com.tkmonkey.contactsappkmm.di.AppModule

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			App(
				darkTheme = isSystemInDarkTheme(),
				dynamicColor = true,
				appModule = AppModule(LocalContext.current.applicationContext)
			)
		}
	}
}
