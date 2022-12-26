package com.note.app.mykotlinproject.currentAge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityCurrentAgeBinding
import com.note.app.mykotlinproject.databinding.ActivityMainBinding
import java.util.*

class CurrentAgeActivity : AppCompatActivity() {
    lateinit var binding: ActivityCurrentAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDone.setOnClickListener {
            val age = binding.etBirth.text.toString().trim()
            getAge(age.toInt())
        }

    }
        fun getAge(age:Int){
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val currentAge= currentYear-age

            binding.tvShow.text=currentAge.toString()
    }
}