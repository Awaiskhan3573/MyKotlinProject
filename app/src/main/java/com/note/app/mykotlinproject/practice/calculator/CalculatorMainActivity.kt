package com.note.app.mykotlinproject.practice.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.note.app.mykotlinproject.R
import kotlinx.android.synthetic.main.activity_main_calculator.*

class CalculatorMainActivity : AppCompatActivity() {
    private val TAG ="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculator)
        var appToolbar: Toolbar = findViewById(toolbar.id)

        Log.d(TAG, "onCreate: ")

        basicButton.setOnClickListener {
            navigateBasic()
        }
        complexButton.setOnClickListener {
            navigateComplex()
        }
    }

    private fun navigateComplex() {
        var it = Intent(this, ComplexCalculatorActivity::class.java)
        startActivity(it)
    }

    private fun navigateBasic() {
        var it = Intent(this, BasicCalculatorActivity::class.java)
        startActivity(it)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.title) {
        "Basic" -> {
            navigateBasic()
            true
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
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}