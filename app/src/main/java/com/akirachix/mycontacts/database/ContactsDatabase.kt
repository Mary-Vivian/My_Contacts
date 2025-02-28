package com.akirachix.mycontacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akirachix.mycontacts.Model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)

abstract class ContactsDatabase: RoomDatabase() {
    abstract fun getContactDao(): ContactDao

//with companion object you don't need to instantiate to access the functionality
    companion object{
        private var database:ContactsDatabase?=null

        fun getDatabase(context: Context):ContactsDatabase{
            if (database==null){
                database= Room.databaseBuilder(context,ContactsDatabase::class.java,"contacts_db").build()
            }
            return database as ContactsDatabase
        }
    }

}