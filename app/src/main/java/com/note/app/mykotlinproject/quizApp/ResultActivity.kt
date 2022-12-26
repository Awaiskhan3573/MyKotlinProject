package com.note.app.mykotlinproject.quizApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val username=intent.getStringExtra(SetData.name)
        val userScore=intent.getStringExtra(SetData.score)
        val totalQuestion=intent.getStringExtra("Total size")
        binding.tvName.text="Congratulation ${username}!!"
        binding.tvShowScore.text="${userScore}/${totalQuestion}"
        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this,QuizAppActivity::class.java))
            finish()
        }

    }
}