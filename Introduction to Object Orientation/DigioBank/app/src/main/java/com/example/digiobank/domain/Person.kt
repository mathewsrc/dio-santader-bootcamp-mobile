package com.example.digiobank.domain

class Person {
    var name:String = "Bill"

    var socialId: String = "123.123.123-11"
    private set

    fun personInfo() = "$name and $socialId"
}