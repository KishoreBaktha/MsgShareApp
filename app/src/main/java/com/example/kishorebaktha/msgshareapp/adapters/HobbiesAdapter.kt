package com.example.kishorebaktha.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kishorebaktha.msgshareapp.models.Hobby
import com.example.kishorebaktha.msgshareapp.R
import com.example.kishorebaktha.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

//Adaper is used to bind model to UI
class HobbiesAdapter(val context:Context,private val hobbies:List<Hobby>):RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>()
{
    companion object {
        val Tag:String=HobbiesAdapter::class.java.simpleName //returns MainActivity
    }
    //below method is for each row in view, so we inflate from list_item
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
      val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)//inflate returns layout as view
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
      return hobbies.size
    }
    //combine data to view, so instead of title,get hobby
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Hobby=hobbies[position]
        holder.setData(Hobby,position)
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var currentHobby: Hobby?=null
        var currentPosition:Int=0
        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title,Toast.LENGTH_LONG)
                }

            }
            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message:String="My hobby is:"+currentHobby!!.title
                    val intent= Intent()
                    intent.action= Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,message)//for applications to recognize like whatsapp or gmail-EXTRAText
                    intent.type="text/plain"
                    context.startActivity(Intent.createChooser(intent,"Share to:"))
                }

            }
        }
     fun setData(hobby: Hobby?, pos:Int)
     {
         hobby?.let {
             itemView.texttitle.text=hobby.title
             this.currentHobby=hobby
             this.currentPosition=pos
         }

     }
    }
}