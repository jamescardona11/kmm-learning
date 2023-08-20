package com.tkmonkey.contactsappkmm.contacts.data

import com.tkmonkey.contactsappkmm.contacts.domain.Contact
import database.ContactEntity

fun ContactEntity.toContact(): Contact {
	return Contact(
		id = id,
		firstName = firstName,
		lastName = lastName,
		email = email,
		phoneNumber = phoneNumber,
		photoBytes = null // TODO
	)
}