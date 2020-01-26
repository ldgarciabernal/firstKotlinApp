package com.luisdavid.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var diceimage1 : ImageView
    lateinit var diceimage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceimage1 = findViewById(R.id.dice_image_1)
        diceimage2 = findViewById(R.id.dice_image_2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetDice() }
    }

    private fun rollDice() {
        val drawableResource1 = getRandomDiceImage()
        val drawableResource2 = getRandomDiceImage()

        diceimage1.setImageResource(drawableResource1)
        diceimage2.setImageResource(drawableResource2)
    }

    private fun getRandomDiceImage() : Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun resetDice() {
        val drawableResource = R.drawable.empty_dice

        diceimage1.setImageResource(drawableResource)
        diceimage2.setImageResource(drawableResource)
    }
}
