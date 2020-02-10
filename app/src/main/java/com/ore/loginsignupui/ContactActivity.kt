package com.ore.loginsignupui

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.contact_scrolling.*
import kotlinx.android.synthetic.main.contact_view.*

class ContactActivity : AppCompatActivity() {
    private val contacts = ArrayList<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        val contacts = ArrayList<Contact>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_scrolling)

        setSupportActionBar(toolbarAll)
        toolbarAll.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp)

        toolbarAll.setNavigationOnClickListener {
            super.onBackPressed()
        }

        val myFabSrc: Drawable = getResources().getDrawable(R.drawable.ic_add_black_24dp)
        val rightColor: Drawable = myFabSrc.getConstantState()!!.newDrawable()
        rightColor.mutate()
            .setColorFilter(getResources().getColor(R.color.background), PorterDuff.Mode.MULTIPLY)
        addNewContactButton.setImageDrawable(rightColor)

        val bundle = intent.extras?.getParcelable<Contact>("CONTACT")
        if (bundle != null) {
            contacts.add(bundle)
        }

        contacts.add(Contact("Olaolu Akintobi", "laolak@gmail.com", "08033087643"))
        contacts.add(Contact("Bukky Akintobi", "bukkson@gmail.com", "08031957892"))
        contacts.add(Contact("Lamide Akintobi", "lamide@gmail.com", "08031957893"))
        contacts.add(Contact("Bobo Brazil", "bobo@gmail.com", "08031957894"))
        contacts.add(Contact("Panshak Deeprak", "panshak@gmail.com", "08031957895"))
        contacts.add(Contact("Festus Abrum", "brumbrum@gmail.com", "08031957896"))
        contacts.add(Contact("Baby Yoda", "babyyoda@gmail.com", "08031957897"))
        contacts.add(Contact("Pedro Pascal", "pedropascal8@gmail.com", "08031957898"))
        contacts.add(Contact("The Mandalorian", "efficacioustrilobyte@gmail.com", "08023387654"))
        contacts.add(Contact("Rick Sanchez", "bambambigelow@gmail.com", "08183087643"))

        contacts.sortBy {
            it.name
        }

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        list.addItemDecoration(itemDecoration)

        val layoutManager = LinearLayoutManager(this)
        list.layoutManager = layoutManager
        list.adapter = ContactsAdapter(contacts, this)

        addNewContactButton.setOnClickListener { view ->
//            val intent = Intent(this, MainBabyBlissLoginUIActivity::class.java)
//
//            startActivity(intent)

            val intent = Intent(applicationContext, MainBabyBlissLoginUIActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            val bundle = intent.extras?.getParcelable<Contact>("CONTACT")
            if (bundle != null) contacts.add(bundle)
        }
    }
}
