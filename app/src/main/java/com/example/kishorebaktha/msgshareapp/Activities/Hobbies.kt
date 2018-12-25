package com.example.kishorebaktha.msgshareapp.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.kishorebaktha.msgshareapp.adapters.HobbiesAdapter
import com.example.kishorebaktha.msgshareapp.R
import com.example.kishorebaktha.msgshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class Hobbies : AppCompatActivity() {

    companion object {
        val Tag:String=Hobbies::class.java.simpleName //returns MainActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val layoutmanager=LinearLayoutManager(this)
        layoutmanager.orientation=LinearLayoutManager.VERTICAL
        recyclerview.layoutManager=layoutmanager
        val adapter= HobbiesAdapter(this, Supplier.Hobbies)
        recyclerview.adapter=adapter
    }
}
