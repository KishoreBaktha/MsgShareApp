package com.example.kishorebaktha.msgshareapp.models

data class Hobby(var title:String)
//static
object Supplier
{
    var Hobbies= listOf(Hobby("Swimming"),
            Hobby("Reading"),
            Hobby("Coding"),
            Hobby("Gaming"))
}