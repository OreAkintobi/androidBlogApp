package com.ore.loginsignupui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ore.loginsignupui.databinding.ContactScrollingBinding

class ContactActivity : AppCompatActivity() {
    private val contacts = ArrayList<Blog>()
    lateinit var binding: ContactScrollingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        val blogPosts = ArrayList<Blog>()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.contact_scrolling)
//        setContentView(R.layout.contact_scrolling)

        setSupportActionBar(binding.toolbarAll)
        binding.toolbarAll.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp)
        binding.toolbarAll.setNavigationOnClickListener {
            super.onBackPressed()
        }

        val bundle = intent.extras?.getParcelable<Blog>(TAG)
        if (bundle != null) {
            blogPosts.add(bundle)
        }

        blogPosts.add(Blog("Olaolu Akintobi", "laolak@gmail.com", "08033087643"))
        blogPosts.add(Blog("Bukky Akintobi", "bukkson@gmail.com", "08031957892"))
        blogPosts.add(Blog("Lamide Akintobi", "lamide@gmail.com", "08031957893"))
        blogPosts.add(Blog("Bobo Brazil", "bobo@gmail.com", "08031957894"))

        blogPosts.sortBy {
            it.title
        }

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = BlogAdapter(blogPosts, this)
        binding.addBlogPostButton.setOnClickListener {
            val intent = Intent(applicationContext, MainBabyBlissLoginUIActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            val bundle = intent.extras?.getParcelable<Blog>("CONTACT")
            if (bundle != null) contacts.add(bundle)
        }
    }
}
