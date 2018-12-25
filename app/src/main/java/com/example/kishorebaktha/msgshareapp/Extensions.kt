package com.example.kishorebaktha.msgshareapp

import android.app.Activity
import android.content.Context
import android.widget.Toast
//Context is superclass of activity
//Default argument
fun Context.showToast(message:String,duration:Int =Toast.LENGTH_SHORT)
{
  Toast.makeText(applicationContext,message,duration).show()
}