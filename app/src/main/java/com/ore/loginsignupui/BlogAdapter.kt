package com.ore.loginsignupui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ore.loginsignupui.databinding.ContactViewBinding

class BlogAdapter(private var blogs: List<Blog>, private var context: Context) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {
    private lateinit var binding: ContactViewBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BlogViewHolder {
        val inflater = LayoutInflater.from(context)
        binding = ContactViewBinding.inflate(inflater, parent, false)
        return BlogViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blogs[position])
        val blog = blogs[position]
        binding.linearStuff.setOnClickListener {
            val intent = Intent(context, MainViewContactActivity::class.java)
            intent.putExtra(TAG, blog)
            context.startActivity(intent)
        }
    }

    class BlogViewHolder(private val binding: ContactViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Blog) {
            binding.blog = data
        }
    }
}