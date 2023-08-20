package com.tkmonkey.contactsappkmm.core.data

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import database.ContactDatabase

object Schema : SqlSchema<QueryResult.AsyncValue<Unit>> by ContactDatabase.Schema {
}