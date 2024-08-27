package com.akirachix.mycontacts.UI

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.mycontacts.Model.Contact
import com.akirachix.mycontacts.databinding.ContactListItemBinding

class ContactAdapter (val contactList: List<Contact>,val context: Context):RecyclerView.Adapter<ContactsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
   var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ContactsViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return contactList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
       val contact =contactList[position]
        holder.binding.tvName.text=contact.name
        holder.binding.tvPhonenumber.text=contact.phoneNumber
        holder.binding.tvEmails.text=contact.email
        holder.binding.cvContact.setOnClickListener {
            val intent=Intent(context,ViewContactsActivity::class.java)
            intent.putExtra("CONTACT_ID", contact.contactId)
            context.startActivity(intent)
        }
    }
}
class ContactsViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root)

