package com.note.app.mykotlinproject.passdataintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivityFirstBinding
import com.note.app.mykotlinproject.recyclerview.Model

class FirstActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Model>
    lateinit var binding:ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsend.setOnClickListener {
            callActivity()
        }
    }
    private fun callActivity() {


        val name:String="hassan"
        val roll:Int=2345
        val id:Double=35.55

       /* val model =Model(name,roll)*/

         list  = ArrayList()
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))
        list.add(Model(name,roll))

        /*val intent =Intent(this,SecondActivity::class.java)
        intent.putExtra("modelname",model)*/
        val intent =Intent(this,SecondActivity::class.java)
        intent.putExtra("modelname",list)
        /*intent.putExtra("name",name)
        intent.putExtra("roll",roll)
        intent.putExtra("id",id)*/
        startActivity(intent)
    }
}