package com.akirachix.mycontacts.UI

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.akirachix.mycontacts.Model.Contact
import com.akirachix.mycontacts.ViewModel.ContactsViewModel
import com.akirachix.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
 val contactsViewmodel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvcontacts.layoutManager = LinearLayoutManager(this)


    }


    override fun onResume() {
        super.onResume()
        binding.fabAddContact.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
         contactsViewmodel.getAllContacts().observe(this){contactsList->
             displayContacts(contactsList)
            }


        }

    fun displayContacts(contactsList:List<Contact>){
        val contactsAdapter=ContactAdapter(contactsList,this)
        binding.rvcontacts.adapter=contactsAdapter


    }
}