package com.example.editingrecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.editingrecyclerview.model.UserData
import com.example.editingrecyclerview.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var addsBtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set List
        userList = ArrayList()

        //set find Id
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)

        //set Adapter
        userAdapter = UserAdapter(this,userList)

        //set Recycler view Adapter
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter

        //set Dialog
        addsBtn.setOnClickListener { addInfo() }


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)

        //set view
        val alert = v.findViewById<EditText>(R.id.alert)

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
                val alerts = alert.text.toString()
                userList.add(UserData("$alerts"))
                userAdapter.notifyDataSetChanged()
                Toast.makeText(this,"Adding Alert Success",Toast.LENGTH_SHORT).show()

                dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
                dialog.dismiss()
                Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }
}