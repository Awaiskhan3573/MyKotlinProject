package com.note.app.mykotlinproject.quizApp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    private var Name:String?=null
    private var score:Int=0
    private var currentPosition:Int=1
    private var selectedOption:Int=0
    private var questionList:ArrayList<QuestionData>? = null
    lateinit var binding: ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        SetData.getQuestion()
//        Show Question On TextView
         Name=intent.getStringExtra(SetData.name)
        questionList=SetData.getQuestion()
        setQuestion()
        binding.option1.setOnClickListener {
            selectedOptionStyle(binding.option1,1)
        }
        binding.option2.setOnClickListener {
            selectedOptionStyle(binding.option2,2)
        }
        binding.option3.setOnClickListener {
            selectedOptionStyle(binding.option3,3)
        }
        binding.option4.setOnClickListener {
            selectedOptionStyle(binding.option4,4)
        }
//        if user cannot select any option and click on submit button ,so go to next question
//        if user select option then your answer wrong or correct
        binding.btnSubmit.setOnClickListener {
            if (selectedOption!=0){
                val question =questionList!![currentPosition-1]
                if (selectedOption!=question.correctAnswer){
                    answerSelectColor(selectedOption,R.drawable.wrong_question_option)
                }else{
                       score++
                }
                answerSelectColor(question.correctAnswer,R.drawable.correct_question_option)
                if (currentPosition==questionList!!.size)
                binding.btnSubmit.text="Finish"
                else
                    binding.btnSubmit.text="Go To Next"
            }else{
                currentPosition++
                Log.d("setQuestion", "setQuestion: ==========$currentPosition")

                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }else->{
                       var intent=Intent(this,ResultActivity::class.java)
                       intent.putExtra(SetData.name,Name.toString())
                       intent.putExtra(SetData.score,score.toString())
                       intent.putExtra("Total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption=0
        }


/*
        var question=questionList!![0]
        binding.tvQuestion.text=question.question
        binding.option1.text=question.optionOne
        binding.option2.text=question.optionTwo
        binding.option3.text=question.optionThree
        binding.option4.text=question.optionFour
        binding.progress.progress=1
        binding.progress.max=questionList!!.size*/
//        var demo=SetData.getQuestion()
//        Log.e("myTest" ,"${demo.size}")

    }
    fun answerSelectColor(opt: Int,color: Int){
        when(opt){
            1->{
                binding.option1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                binding.option2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                binding.option3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                binding.option4.background=ContextCompat.getDrawable(this,color)
            }
        }

    }
    fun setQuestion(){
        val question =questionList!![currentPosition-1]
        setOptionStyle()

        Log.d("setQuestion", "setQuestion: ==========$currentPosition")
        binding.progress.progress=currentPosition
        binding.progress.max=questionList!!.size

        binding.progressText.text="$currentPosition/${questionList!!.size}"
        binding.tvQuestion.text=question.question
        binding.option1.text=question.optionOne
        binding.option2.text=question.optionTwo
        binding.option3.text=question.optionThree
        binding.option4.text=question.optionFour
        binding.btnSubmit.text = "Submit"


    }
    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,binding.option1)
        optionList.add(1,binding.option2)
        optionList.add(2,binding.option3)
        optionList.add(3,binding.option4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("grey"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }

    }
    fun selectedOptionStyle(view: TextView,opt: Int){
        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#FF000000"))

    }
}