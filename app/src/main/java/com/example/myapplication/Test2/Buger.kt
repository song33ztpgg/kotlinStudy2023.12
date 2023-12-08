package com.example.myapplication.Test2

class Buger:Food{

    var name:String
    constructor(_name:String) {
        name = _name
    }

    fun bugerView(){
        println("${name}")
    }
}