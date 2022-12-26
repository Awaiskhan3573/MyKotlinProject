package com.note.app.mykotlinproject.currentlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityCurrentLocationBinding

class CurrentLocationActivity : AppCompatActivity() {
    lateinit var binding: ActivityCurrentLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCurrentLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}