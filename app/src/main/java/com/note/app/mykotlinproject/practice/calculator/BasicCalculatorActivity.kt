package com.note.app.mykotlinproject.practice.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.note.app.mykotlinproject.R
import kotlinx.android.synthetic.main.activity_basic_calculator.*

class BasicCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_calculator)
        var toolbar: Toolbar = findViewById(toolbar.id)


        plusButton.setOnClickListener { view -> operation("plus"); view.clearFocus() }
        minusButton.setOnClickListener { view -> operation("minus"); view.clearFocus() }
        divideButton.setOnClickListener { view -> operation("divide"); view.clearFocus() }
        multiplyButton.setOnClickListener { view -> operation("multiply"); view.clearFocus() }
    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }*/

   /* private fun navigateComplex() {
        var it = Intent(this, ComplexCalculatorActivity::class.java)
        startActivity(it)
    }*/

 /*   private fun navigateBasic() {
        var it = Intent(this, BasicCalculatorActivity::class.java)
        startActivity(it)
    }*/

   /* override fun onOptionsItemSelected(item: MenuItem) = when (item.title) {
        "Basic" -> {
            false
        }
        "Complex" -> {
            navigateComplex()
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }*/

    private fun operation(type: String) {
        try {
            val value1 = input1.text.toString().toDouble()
            val value2 = input2.text.toString().toDouble()
            calculate(type, value1, value2)
        }
        catch(e: NumberFormatException){

        }
    }

    private fun calculate(type: String, value1: Double, value2: Double) {
     /*   Log.d("TYPE", type)
        if (type == "plus") {
            val result = sumFunction(value1,value2)
            Log.d("CALC", "$result")
            resultText.text = result.toString()
        } else if (type == "minus") {
            val result = value1 - value2
            Log.d("CALC", "$result")
            resultText.text = result.toString()
        } else if (type == "divide") {
            if (value2 != 0.0) {
                val result = value1 / value2
                Log.d("CALC", "$result")
                resultText.text = result.toString()
            }
        } else if (type === "multiply") {
            val result = value1 * value2
            Log.d("CALC", "$result")
            resultText.text = result.toString()
        }*/
        val result=when(type){
            "plus"->value1+value2
            "minus"->value1-value2
            "multiply"->value1*value2
            else-> value1/value2
        }
        resultText.text =result.toString()
    }

    fun sumFunction(one:Double,two:Double):Double{
        return one+two
    }
}