package com.example.myapplication.Kiosk2

class AllBearList:Food {
    var bearName:String
    var bearPrice:Double
    var bearExpain:String

    constructor(_bearName:String,_bearPrice:Double,_bearExpain:String){
        bearName =_bearName
        bearPrice =_bearPrice
        bearExpain = _bearExpain
    }

    override fun view() {
        val formatted = String.format("%-15s %.2f %s", bearName, bearPrice,bearExpain)
        println(formatted)
    }

}