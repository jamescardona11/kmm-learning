package com.tkmonkey.contactsappkmm.di

import com.tkmonkey.contactsappkmm.contacts.domain.ContactDataSource

expect class AppModule {
	val contactDataSource: ContactDataSource
}