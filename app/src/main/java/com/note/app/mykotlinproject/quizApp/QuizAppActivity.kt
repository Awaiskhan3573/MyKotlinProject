package com.note.app.mykotlinproject.quizApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityQuizAppBinding

class QuizAppActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityQuizAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Hide Status Bar
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        binding.btnNext.setOnClickListener {
            if(binding.etName.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }else{
                var intent=Intent(this,QuestionsActivity::class.java)
                intent.putExtra("${SetData.name}",binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}