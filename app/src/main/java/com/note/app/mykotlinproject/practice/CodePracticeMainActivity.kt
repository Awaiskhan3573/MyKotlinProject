package com.note.app.mykotlinproject.practice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.getSystemService
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.practice.calculator.CalculatorMainActivity
import kotlinx.android.synthetic.main.activity_code_practice_main.*
import java.util.*
import kotlin.random.Random


class CodePracticeMainActivity : AppCompatActivity() {
    lateinit var btnDice:Button
    private lateinit var btnColor:Button
    private lateinit var btnCalculator:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_practice_main)
        btnDice=findViewById(R.id.btnDice)
        btnColor=findViewById(R.id.btnColor)
        btnCalculator=findViewById(R.id.btnCalculator)


        btnDice.setOnClickListener {
            startActivity(Intent(this,DiceRollerActivity::class.java))
        }
        btnColor.setOnClickListener {
            startActivity(Intent(this,ColorViewsActivity::class.java))
        }
        btnCalculator.setOnClickListener {
            startActivity(Intent(this,CalculatorMainActivity::class.java))
        }

    }
}

