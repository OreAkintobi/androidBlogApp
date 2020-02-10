package com.ore.loginsignupui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter(var list: ArrayList<Contact>, var context: Context): RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_view, parent,false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = list[position]
        holder.contactName.text = contact.name
        holder.contactEmail.text = contact.email
        holder.contactPhone.text = contact.phone
//        Glide.with(context).asBitmap().load("https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80").centerCrop().fallback(R.drawable.ic_contact_logo_main).error(R.drawable.ic_add_contact_logo).placeholder(R.drawable.ic_contact_logo_main).into(holder.contactImage)

        holder.itemView.setOnClickListener{
            val intent = Intent(context, MainViewContactActivity::class.java)
            intent.putExtra("NAME", contact.name)
            intent.putExtra("EMAIL", contact.email)
            intent.putExtra("PHONE", contact.phone)
            context.startActivity(intent)
        }

//        holder.contactCall.setOnClickListener {
//            val number = holder.contactPhone.text.toString().trim()
//
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + Uri.encode(number)))
//            try {
//                startActivity(holder.contactPhone.context, intent, null)
//            } catch (e: Exception){
//                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view){
        var contactName: TextView = view.findViewById(R.id.contactName)
        var contactEmail: TextView = view.findViewById(R.id.contactEmail)
        var contactPhone: TextView = view.findViewById(R.id.contactPhone)
//        var contactCall: ImageView = view.findViewById(R.id.contactCall)
//        var contactImage: ImageView = view.findViewById(R.id.contactImageTwo)
    }
}