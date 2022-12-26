package com.note.app.mykotlinproject.passdataintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.ActivitySecondBinding
import com.note.app.mykotlinproject.recyclerview.Model

class SecondActivity : AppCompatActivity() {
    lateinit var bindActivitySecondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindActivitySecondBinding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindActivitySecondBinding.root)

    /*    val namet= intent.getStringExtra("name")
        val rolld= intent.getIntExtra("roll",0)
        val ida= intent.getDoubleExtra("id",0.0)*/

      /*  val model=intent.getParcelableExtra<Model>("modelname")
        bindActivitySecondBinding.tvName.text=model?.title
        bindActivitySecondBinding.tvId.text=model?.image.toString()*/

        val mlist=intent.getParcelableArrayListExtra<Model>("modelname")
        bindActivitySecondBinding.tvName.text=mlist?.get(0)?.title
        bindActivitySecondBinding.tvId.text=mlist?.get(0)?.image.toString()
        bindActivitySecondBinding.tvRoll.text=mlist?.size.toString()



       /* bindActivitySecondBinding.tvName.text=namet
        bindActivitySecondBinding.tvRoll.text=rolld.toString()
        bindActivitySecondBinding.tvId.text=ida.toString()*/
    }
}