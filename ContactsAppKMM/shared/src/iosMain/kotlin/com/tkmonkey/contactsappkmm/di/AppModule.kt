package com.tkmonkey.contactsappkmm.di

import com.tkmonkey.contactsappkmm.contacts.data.SqlDelightContactDataSource
import com.tkmonkey.contactsappkmm.contacts.domain.ContactDataSource
import com.tkmonkey.contactsappkmm.core.data.DriverFactory
import database.ContactDatabase

actual class AppModule() {
	actual val contactDataSource: ContactDataSource by lazy {
		SqlDelightContactDataSource(
			db = ContactDatabase(
				DriverFactory().createDriver()
			)
		)
	}

}