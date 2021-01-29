package com.thirkazh.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thirkazh.diceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRoll.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    private fun rollDice() {
        // create new dice with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //update the image view with the correct drawable resource ID
        binding.imgDice.setImageResource(drawableResource)

        // update the text
        binding.txtResult.text = diceRoll.toString()
    }
}