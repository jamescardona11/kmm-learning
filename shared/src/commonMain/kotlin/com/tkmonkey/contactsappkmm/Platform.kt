package com.tkmonkey.contactsappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform