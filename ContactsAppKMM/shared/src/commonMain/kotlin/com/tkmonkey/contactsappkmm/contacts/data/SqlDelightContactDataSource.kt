package com.tkmonkey.contactsappkmm.contacts.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tkmonkey.contactsappkmm.contacts.domain.Contact
import com.tkmonkey.contactsappkmm.contacts.domain.ContactDataSource
import database.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactDataSource(db: ContactDatabase) : ContactDataSource {

	private val queries = db.contactsQueries
	override fun getContacts(): Flow<List<Contact>> {

		return queries
			.getContacts()
			.asFlow()
			.mapToList(Dispatchers.Default)
			.map {
				it.map { contactEntity ->
					contactEntity.toContact()
				}
			}
	}

	override fun getRecentContacts(amount: Int): Flow<List<Contact>> {
		return queries
			.getRecentContacts(amount.toLong())
			.asFlow()
			.mapToList(Dispatchers.Default)
			.map {
				it.map { contactEntity ->
					contactEntity.toContact()
				}
			}
	}

	override suspend fun insertContact(contact: Contact) {
		queries.insertContactEntity(
			id = contact.id,
			firstName = contact.firstName,
			lastName = contact.lastName,
			email = contact.email,
			createdAt = Clock.System.now().toEpochMilliseconds(),
			phoneNumber = contact.phoneNumber,
			imagePath = null,
		)
	}

	override suspend fun deleteContact(id: Long) {
		queries.deleteContactEntity(id)
	}

}