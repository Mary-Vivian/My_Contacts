package com.akirachix.mycontacts.UI

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.databinding.ActivityViewContactsBinding

class ViewContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactsBinding
    var contactId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityViewContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras!=null){
            contactId=intent.getIntExtra("CONTACT_ID",0)
        }
     else{
         finish()
        }
    }
}
