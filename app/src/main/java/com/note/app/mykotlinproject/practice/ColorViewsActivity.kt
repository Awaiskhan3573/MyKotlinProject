package com.note.app.mykotlinproject.practice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.note.app.mykotlinproject.R
import kotlinx.android.synthetic.main.activity_color_views.*

class ColorViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_views)
        setListners()
    }

    private fun setListners() {
        val cilckableViews:List<View> = listOf(tvOne,tvTwo,tvThree,tvFour,tvFive,cl,btnWhite,btnChocolate,btnOrange)


        for (item in cilckableViews){
            item.setOnClickListener {
                makeColor(it)
            }
        }

    }

    private fun makeColor(view: View) {
        when(view.id){
            R.id.tvOne->view.setBackgroundColor(Color.GRAY)
            R.id.tvTwo->view.setBackgroundColor(Color.GREEN)
            R.id.tvThree->view.setBackgroundColor(Color.RED)
            R.id.tvFour->view.setBackgroundColor(Color.BLACK)
            R.id.tvFive->view.setBackgroundColor(Color.YELLOW)
            R.id.btnWhite->tvThree.setBackgroundResource(R.color.purple_200)
            R.id.btnOrange->tvFour.setBackgroundResource(R.color.orange)
            R.id.btnChocolate->tvFive.setBackgroundResource(R.color.chocolate)

            else->view.setBackgroundColor(Color.BLUE)
        }

    }

}