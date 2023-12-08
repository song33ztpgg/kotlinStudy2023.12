package com.example.myapplication.Kiosk

class Burger(_bugername:String,_bugerPrice:Double,_bugerExpain:String) {

    var bugerName:String
    var bugerPrice:Double
    var bugerExpain:String

    init {
        bugerName = _bugername
        bugerPrice = _bugerPrice
        bugerExpain = _bugerExpain
    }


    fun view(){
        println("${bugerName} || ${bugerPrice} || ${bugerExpain}")
    }

}