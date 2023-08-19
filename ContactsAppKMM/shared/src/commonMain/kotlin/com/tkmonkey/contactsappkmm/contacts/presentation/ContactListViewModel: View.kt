package com.tkmonkey.contactsappkmm.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.tkmonkey.contactsappkmm.contacts.domain.Contact
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactListViewModel : ViewModel() {

	private val _state: MutableStateFlow<ContactListState> = MutableStateFlow(
		ContactListState(
			contacts = contacts
		)
	)
	val state = _state.asStateFlow()

	var newContact: Contact? by mutableStateOf(null)
		private set

	fun onEvent(event: ContactListEvent) {

	}
}

private val contacts = (1..50).map {
	Contact(
		id = it.toLong(),
		firstName = randomName(),
		lastName = randomLastName(),
		phoneNumber = "1234567890",
		email = "$it@dummy",
		photosByte = null
	)
}

private fun randomName(): String {
	val firstNameList = listOf("Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac", "Jessica")


	val randomFirstName = firstNameList.random()


	return "$randomFirstName "

}

private fun randomLastName(): String {

	val lastNameList = listOf("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor")


	val randomLastName = lastNameList.random()

	return " $randomLastName"

}