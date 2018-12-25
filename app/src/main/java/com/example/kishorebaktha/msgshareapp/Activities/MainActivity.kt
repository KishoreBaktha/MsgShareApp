package com.example.kishorebaktha.msgshareapp.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kishorebaktha.msgshareapp.Constants
import com.example.kishorebaktha.msgshareapp.R
import com.example.kishorebaktha.msgshareapp.R.id.*
import com.example.kishorebaktha.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val Tag:String=MainActivity::class.java.simpleName //returns MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonshowtoast.setOnClickListener {
            Log.i(Tag,"button clicked again ")
            showToast(resources.getString(R.string.show_toast_buttonclicked))
        }
        sendmessage.setOnClickListener {
            val message= edmessage.text.toString()//no setter and getter
            //Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
                    //we know target activity so it is called explicit intent
            val intent=Intent(this, SecondActivity::class.java)//concept of reflection
            intent.putExtra(Constants.usage_message_key,message)
            startActivity(intent)
        }
        buttonsharetootherapp.setOnClickListener{
            val message= edmessage.text.toString()
            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)//for applications to recognize like whatsapp or gmail-EXTRAText
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share to:"))
        }
//        recylcerviewbutton.setOnClickListener {
//            val Intent=Intent(this, Hobbies::class.java);
//            startActivity(Intent)
//        }
    }
}
