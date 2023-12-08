package com.example.myapplication.Kiosk2

class AllBurgerList: Food{
    var bugerName:String
    var bugerPrice:Double
    var bugerExpain:String

    constructor(_bugername: String,_bugerPrice: Double,_bugerExpain: String) {
        bugerName = _bugername
        bugerPrice = _bugerPrice
        bugerExpain = _bugerExpain
    }

    override fun view() {
        val formatted = String.format("%-15s %.2f %s", bugerName, bugerPrice,bugerExpain)
        println(formatted)

    }


}

