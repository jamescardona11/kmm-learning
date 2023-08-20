//package com.tkmonkey.contactsappkmm.core.data
//
//import app.cash.sqldelight.db.SqlDriver
//import app.cash.sqldelight.driver.native.NativeSqliteDriver
//
//
//actual class DriverFactory {
//	actual fun createDriver(): SqlDriver {
//		return NativeSqliteDriver(
//			Schema,
//			"test.db",
//			maxReaderConnections = 4
//		)
//	}
//}