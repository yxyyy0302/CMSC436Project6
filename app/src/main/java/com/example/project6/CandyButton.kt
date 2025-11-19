package com.example.project6

import android.content.Context
import androidx.appcompat.widget.AppCompatButton

class CandyButton : AppCompatButton {

    private lateinit var candy : Candy

    constructor(context: Context, candy: Candy) : super(context) {
        this.candy = candy
        text = candy.getName() + "\n" + candy.getPrice()
        textSize = 16f
    }

    fun getCandy(): Candy {
        return candy
    }

    fun getCandyPrice(): Double {
        return candy.getPrice()
    }
}