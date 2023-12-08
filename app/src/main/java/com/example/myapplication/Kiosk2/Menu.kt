package com.example.myapplication.Kiosk2

open class Menu(_menuName:String,_menuExpain:String){

    var menuName:String =""
    var menuExpain:String =""

    init{
        menuName = _menuName
        menuExpain = _menuExpain
    }




    open fun view(){
        println("${menuName}     ||${menuExpain} ")
    }
}