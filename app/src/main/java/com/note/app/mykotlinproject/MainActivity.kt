package com.note.app.mykotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.note.app.mykotlinproject.coroutine.CoroutinesActivity
import com.note.app.mykotlinproject.currencyconveerter.CurrencyConverterActivity
import com.note.app.mykotlinproject.currentAge.CurrentAgeActivity
import com.note.app.mykotlinproject.databinding.ActivityMainBinding
import com.note.app.mykotlinproject.mvvm.MvvmMainActivity
import com.note.app.mykotlinproject.passdataintent.FirstActivity
import com.note.app.mykotlinproject.practice.CodePracticeMainActivity
import com.note.app.mykotlinproject.practice.ColorViewsActivity
import com.note.app.mykotlinproject.quizApp.QuizAppActivity
import com.note.app.mykotlinproject.recyclerview.GridRecyclerViewActivity
import com.note.app.mykotlinproject.retrofitcoroutines.RectrofitCoroutineMainActivity
import com.note.app.mykotlinproject.retrofitmvvm.RetrofitMvvmMainActivity
import com.note.app.mykotlinproject.roomdatabase.KhataActivity
import com.note.app.mykotlinproject.spinner.SpinnerActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAge.setOnClickListener {
            val intent=Intent(this,CurrentAgeActivity::class.java)
            startActivity(intent)
        }
        binding.btnQuiz.setOnClickListener {
            val intent =Intent(this,QuizAppActivity::class.java)
            startActivity(intent)
        }
        binding.btnCoroutines.setOnClickListener {
            val intent =Intent(this,CoroutinesActivity::class.java)
            startActivity(intent)
        }
        binding.btnMvvm.setOnClickListener {
            val intent =Intent(this,MvvmMainActivity::class.java)
            startActivity(intent)
        }
        binding.btnRetrofit.setOnClickListener {
            val intent =Intent(this,RectrofitCoroutineMainActivity::class.java)
            startActivity(intent)
        }
        binding.btnRetrofitmvvm.setOnClickListener {
            val intent =Intent(this,SpinnerActivity::class.java)
            startActivity(intent)
        }
        binding.btnPractice.setOnClickListener {
            val intent =Intent(this,CodePracticeMainActivity::class.java)
            startActivity(intent)
        }
        binding.btnRoomDataBase.setOnClickListener {
            val intent =Intent(this,KhataActivity::class.java)
            startActivity(intent)
        }
        binding.btnGridRecycler.setOnClickListener {
            val intent =Intent(this,GridRecyclerViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnSendData.setOnClickListener {
            val intent =Intent(this,FirstActivity::class.java)
            startActivity(intent)
        }
        binding.btnCurrency.setOnClickListener {
            val intent =Intent(this,CurrencyConverterActivity::class.java)
            startActivity(intent)
        }







    }

    }





