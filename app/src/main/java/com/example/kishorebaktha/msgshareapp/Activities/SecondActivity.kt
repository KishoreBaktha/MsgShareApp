package com.example.kishorebaktha.msgshareapp.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kishorebaktha.msgshareapp.Constants
import com.example.kishorebaktha.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object {
        val Tag:String=SecondActivity::class.java.simpleName //returns MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //safe call with ?.
        //safe call with ?.let{}
        val bundle: Bundle?=intent.extras//nullable operator(?) so !! for not null

        //let will not execute if bundle is null
        bundle?.let {
            usermessage.text=bundle.getString(Constants.usage_message_key)
        }

       // Toast.makeText(applicationContext,bundle!!.getString("message"),Toast.LENGTH_SHORT).show()
    }
}
