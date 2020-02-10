package com.ore.loginsignupui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import kotlinx.android.synthetic.main.activity_main_baby_bliss_login_ui.*
import kotlinx.android.synthetic.main.activity_main_baby_bliss_login_ui.toolbar


class MainBabyBlissLoginUIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_baby_bliss_login_ui)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp)

        toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }

        addContactButton.setOnClickListener { saveContact() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu1) {
            saveContact()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveContact() {
        val nameValue = name.text.toString()
        val emailValue = email.text.toString()
        val blogPost = blogPost.text.toString()

        if (
            blogPost.validator()
                .nonEmpty()
                .addErrorCallback {
                    Toast.makeText(this, "Please Enter a Valid Blog Post", Toast.LENGTH_LONG)
                        .show()
                }.check() && emailValue.validator()
                .validEmail()
                .nonEmpty()
                .addErrorCallback {
                    Toast.makeText(this, "Please Enter a Valid Email", Toast.LENGTH_LONG).show()
                }.check() && nameValue.nonEmpty {
                Toast.makeText(this, "Please Enter a Title", Toast.LENGTH_LONG).show()
            }
        ) {

            val intent = Intent(this, ContactActivity::class.java)

//            intent.putExtra("CONTACT", Contact(nameValue, emailValue, phoneValue))
//
//            startActivity(intent)

            intent.putExtra("CONTACT", Contact(nameValue, emailValue, blogPost))
            setResult(Activity.RESULT_OK, intent)
            startActivity(intent)
            finish()
        }
    }
}
