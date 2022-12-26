package com.note.app.mykotlinproject.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityGridRecyclerViewBinding
import com.note.app.mykotlinproject.practice.calculator.BasicCalculatorActivity
import com.note.app.mykotlinproject.practice.calculator.CalculatorMainActivity
import com.note.app.mykotlinproject.practice.calculator.ComplexCalculatorActivity
import com.note.app.mykotlinproject.quizApp.QuizAppActivity
import com.note.app.mykotlinproject.recyclerview.callback.UsingCallBack
import kotlinx.android.synthetic.main.activity_second.*

class GridRecyclerViewActivity : AppCompatActivity() {
    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
//    lateinit var courseRV: RecyclerView

    lateinit var adapter: Adapter
     val list= ArrayList<Model>()
    lateinit var binding: ActivityGridRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGridRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // on below line we are initializing
        // our views with their ids.
//        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
//        list = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(this, 2)

        binding.idRVCourses.layoutManager = layoutManager

        // on below line we are initializing our adapter
        adapter = Adapter(this,list,object :UsingCallBack{
           /* override fun onClickItem(model: Model) {
                Toast.makeText(this@GridRecyclerViewActivity, "${model.title}",Toast.LENGTH_SHORT).show()
            }*/

            override fun onClickItem(model: Model, position: Int) {
                when(position){
                    0 -> {val intent= Intent(this@GridRecyclerViewActivity,CalculatorMainActivity::class.java)
                        startActivity(intent)}
                    1 -> {val intent= Intent(this@GridRecyclerViewActivity,CalculatorMainActivity::class.java)
                        startActivity(intent)}
                    2 -> {val intent= Intent(this@GridRecyclerViewActivity,QuizAppActivity::class.java)
                        startActivity(intent)}
                    3 -> {val intent= Intent(this@GridRecyclerViewActivity,BasicCalculatorActivity::class.java)
                        startActivity(intent)}
                    4 -> {val intent= Intent(this@GridRecyclerViewActivity,ComplexCalculatorActivity::class.java)
                        startActivity(intent)}
                }

            }



        })

        // on below line we are setting
        // adapter to our recycler view.
        binding.idRVCourses.adapter = adapter

        // on below line we are adding data to our list
        list.add(Model("Android Development", R.drawable.android))
        list.add(Model("C++ Development", R.drawable.dice_1))
        list.add(Model("Java Development", R.drawable.dice_2))
        list.add(Model("Python Development", R.drawable.dice_3))
        list.add(Model("JavaScript Development", R.drawable.dice_4))
        list.add(Model("JavaScript Development", R.drawable.dice_4))

        // on below line we are notifying adapter
        // that data has been updated.
        adapter.notifyDataSetChanged()



    }
}