package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DiceRollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roll)

        val btn: Button = findViewById(R.id.button)
        var txt1: TextView = findViewById(R.id.textView2)
        var txt4: TextView = findViewById(R.id.textView4)

        btn.setOnClickListener {
            val myFirstDis = Dice(6)
            val rollVlaue = myFirstDis.roll()
            txt1.text = rollVlaue.toString()

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            val luckyWinner = 4
            val img1: ImageView = findViewById(R.id.imageView2)


            val drawableResource = when (rollVlaue) {
                luckyWinner -> (R.drawable.dice_4)
                1 -> (R.drawable.dice_1)
                2 -> (R.drawable.dice_2)
                3 -> (R.drawable.dice_3)
                5 -> (R.drawable.dice_5)
                else -> (R.drawable.dice_6)

            }
            img1.setImageResource(drawableResource)

        }

    }

    class Dice(val num: Int) {

        fun roll(): Int {
            return (1..num).random()
        }
    }
}