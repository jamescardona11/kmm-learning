package com.tkmonkey.contactsappkmm.contacts.presentation

import com.tkmonkey.contactsappkmm.contacts.domain.Contact

sealed interface ContactListEvent {
	object OnAddNewContactClick : ContactListEvent
	object DismissContact : ContactListEvent
	data class OnFirstNameChanged(val firstName: String) : ContactListEvent
	data class OnLastNameChanged(val lastName: String) : ContactListEvent
	data class OnEmailChanged(val email: String) : ContactListEvent
	data class OnPhoneNumberChanged(val phoneNumber: String) : ContactListEvent
	class OnPhotoPicked(val bytes: ByteArray) : ContactListEvent
	object OnAddPhotoClicked : ContactListEvent
	object SaveContact : ContactListEvent
	data class SelectContact(val contact: Contact) : ContactListEvent
	data class EditContact(val contact: Contact) : ContactListEvent
	object DeleteContact : ContactListEvent
}