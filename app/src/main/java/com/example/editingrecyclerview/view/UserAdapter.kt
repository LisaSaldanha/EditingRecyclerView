package com.example.editingrecyclerview.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.editingrecyclerview.R
import com.example.editingrecyclerview.model.UserData

class UserAdapter(val c:Context, val userList: ArrayList<UserData>) :RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{
    inner class UserViewHolder(val v: View):RecyclerView.ViewHolder(v) {
        val name = v.findViewById<TextView>(R.id.mTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item,parent,false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.name.text = newList.alert
    }
}