package com.ore.loginsignupui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ore.loginsignupui.databinding.ActivityMainBabyBlissLoginUiBinding
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import kotlinx.android.synthetic.main.activity_main_baby_bliss_login_ui.*

const val TAG = "BLOG"

class MainBabyBlissLoginUIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBabyBlissLoginUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_baby_bliss_login_ui)
//        setContentView(R.layout.activity_main_baby_bliss_login_ui)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp)
        binding.toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }

        binding.saveBlogButton.setOnClickListener { saveBlog() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu1) {
            saveBlog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveBlog() {

        if (
            binding.blogPost.validator()
                .nonEmpty()
                .addErrorCallback {
                    Toast.makeText(this, "Please Enter a Valid Blog Post", Toast.LENGTH_LONG)
                        .show()
                }.check() && binding.blogEmail.validator()
                .validEmail()
                .nonEmpty()
                .addErrorCallback {
                    Toast.makeText(this, "Please Enter a Valid Email", Toast.LENGTH_LONG).show()
                }.check() && binding.blogTitle.nonEmpty {
                Toast.makeText(this, "Please Enter a Title", Toast.LENGTH_LONG).show()
            }
        ) {

            val intent = Intent(this, ContactActivity::class.java)

            intent.putExtra(
                TAG,
                Blog(blogTitle.text.toString(), blogEmail.text.toString(), blogPost.text.toString())
            )
            setResult(Activity.RESULT_OK, intent)
            startActivity(intent)
            finish()
        }
    }
}
