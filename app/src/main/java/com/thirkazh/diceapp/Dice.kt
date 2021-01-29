package com.thirkazh.diceapp

class Dice(val number: Int) {

    fun roll(): Int{
        return(1..number).random()
    }
}