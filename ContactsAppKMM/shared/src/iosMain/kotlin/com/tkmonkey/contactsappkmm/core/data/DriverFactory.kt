package com.tkmonkey.contactsappkmm.core.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import database.ContactDatabase


actual class DriverFactory {
	actual fun createDriver(): SqlDriver {
		return NativeSqliteDriver(
			ContactDatabase.Schema,
			"test.db",
		)
	}
}