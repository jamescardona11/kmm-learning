//package com.tkmonkey.contactsappkmm.core.data
//
//import android.content.Context
//import app.cash.sqldelight.db.SqlDriver
//import app.cash.sqldelight.driver.android.AndroidSqliteDriver
//import database.ContactDatabase
//
//actual class DriverFactory(private val context: Context) {
//	actual fun createDriver(): SqlDriver {
//		return AndroidSqliteDriver(Schema, context)
//	}
//}