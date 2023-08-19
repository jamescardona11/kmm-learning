package com.tkmonkey.contactsappkmm.contacts.presentation

import com.tkmonkey.contactsappkmm.contacts.domain.Contact

sealed interface ContactListEvent {
	object OnAddNewContactClick: ContactListEvent
	object DismissContact: ContactListEvent
	data class OnFirstNameChange(val firstName: String): ContactListEvent
	data class OnLastNameChange(val lastName: String): ContactListEvent
	data class OnEmailChange(val email: String): ContactListEvent
	data class OnPhoneNumberChange(val phoneNumber: String): ContactListEvent
	class OnPhotoPicked(val bytes: ByteArray): ContactListEvent
	object OnAddPhotoClicked: ContactListEvent
	object SaveContact: ContactListEvent
	data class SelectContact(val contact: Contact): ContactListEvent
	data class EditContact(val contact: Contact): ContactListEvent
	object DeleteContact: ContactListEvent
}