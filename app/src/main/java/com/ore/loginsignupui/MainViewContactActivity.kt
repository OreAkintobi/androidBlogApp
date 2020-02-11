package com.ore.loginsignupui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ore.loginsignupui.databinding.ActivityMainViewContactBinding

class MainViewContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainViewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_view_contact)

        // sets up Tool Bar for Activity
        setSupportActionBar(binding.toolbar)
        // sets up Back Navigation Icon
        binding.toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp)
        // sets up event listener for Back Navigation Icon
        binding.toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }

        val bundle = intent.extras
        val blog = bundle?.getParcelable<Blog>("BLOG")
        binding.blog = blog

//        Glide.with(this).asBitmap().load("https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80").centerCrop().fallback(R.drawable.ic_contact_logo_main).error(R.drawable.ic_add_contact_logo).placeholder(R.drawable.ic_contact_logo_main).into(contactImageTwo)
    }
}
