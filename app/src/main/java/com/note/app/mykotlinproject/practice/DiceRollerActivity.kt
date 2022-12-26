package com.note.app.mykotlinproject.practice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.note.app.mykotlinproject.R
import kotlin.random.Random

class DiceRollerActivity : AppCompatActivity() {

    private lateinit var diceImageView: ImageView
    lateinit var nick: EditText
    lateinit var show: TextView
    lateinit var change: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
        diceImageView = findViewById(R.id.btnDice)
        nick = findViewById(R.id.etnick)
        show = findViewById(R.id.tvTextChange)
        change = findViewById(R.id.btnchange)
        val roll: Button = findViewById(R.id.btnRoll)
        roll.setOnClickListener {
            rollDice()
        }
        change.setOnClickListener {
            textConvert(it)
        }
    }
    private fun textConvert(view: View) {
        show.text = nick.text
        show.visibility = View.VISIBLE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun rollDice() {
        val dicePicture = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageView.setImageResource(dicePicture)
    }
}


