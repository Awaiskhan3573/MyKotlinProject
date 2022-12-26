package com.note.app.mykotlinproject.roomdatabase

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.note.app.mykotlinproject.databinding.ActivityKhataBinding
import com.note.app.mykotlinproject.mvvm.QuoteDatabase
import com.note.app.mykotlinproject.roomdatabase.adapter.DataAdapter
import com.note.app.mykotlinproject.roomdatabase.callback.ClickAbleCallBack
import com.note.app.mykotlinproject.roomdatabase.database.DataRepository
import com.note.app.mykotlinproject.roomdatabase.database.MainViewModelData
import com.note.app.mykotlinproject.roomdatabase.database.MainViewModelDataFactory
import com.note.app.mykotlinproject.roomdatabase.model.DataModel
import kotlinx.android.synthetic.main.activity_khata.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KhataActivity : AppCompatActivity() {
    lateinit var binding: ActivityKhataBinding
    lateinit var dataAdapter: DataAdapter
    lateinit var list:ArrayList<DataModel>
    lateinit var mainViewModelData: MainViewModelData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKhataBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* Handler().postDelayed({
            binding.btnOK.visibility=View.GONE
        },3000)*/

        val sp:SharedPreferences =getSharedPreferences("MyFile", MODE_PRIVATE)
           val data =sp.getBoolean("MyData",false)
        Log.d("TAG", "onCreate: $data")

        binding.btnOK.setOnClickListener {
//            val sp: SharedPreferences = getSharedPreferences("MyFile", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putBoolean("MyData", true)
            editor.apply()

        }
        if (data){
            binding.btnOK.visibility=View.GONE
        }



        fabAdd.setOnClickListener {
            val dialogueBox=DialogeKhataApp(this,this)
            dialogueBox.show()
        }

        val dao = QuoteDatabase.getDatabase(this).dataDao()
        val dataRepository = DataRepository(dao)
        val factory = MainViewModelDataFactory(dataRepository)
        mainViewModelData =
            ViewModelProvider(this, factory).get(MainViewModelData::class.java)
         mainViewModelData.getData().observe(this, Observer {
           setRecyclerViewData(it as ArrayList<DataModel>)
             getLunchTotalAmount(it )

         })
    }
    private fun setRecyclerViewData(arrayList: ArrayList<DataModel>) {

        dataAdapter = DataAdapter(this, arrayList,object :ClickAbleCallBack{
            override fun itemClick(position:Int) {
                CoroutineScope(Dispatchers.IO).launch {
                    QuoteDatabase.getDatabase(this@KhataActivity).dataDao().delete(arrayList[position])
//                arrayList.remove(arrayList[position])
                    arrayList.removeAt(position)
                }
            }

        })
        binding.recyclerData.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                this@KhataActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = dataAdapter
        }
    }
    private fun getLunchTotalAmount(list:ArrayList<DataModel>){
        var sumLunch =0
        var sumDinner =0
        var sumBF =0
        var sumAll =0
        for (i in 0 until list.size) {
                when (list[i].typeFood) {
                    "LUNCH" -> {
                        sumLunch += list[i].Amount.toInt()
                        binding.tvLunch.text= "Lunch Amount :      $sumLunch"
                    }
                    "BreakFast" ->{
                        sumBF += list[i].Amount.toInt()
                        binding.tvBF.text=    "BreakFast Amount :  $sumBF"
                    }
                    "DINNER" -> {
                        sumDinner += list[i].Amount.toInt()
                        binding.tvDinner.text="Dinner Amount:      $sumDinner"
                    }
                }
            }

            sumAll=sumDinner+sumBF+sumLunch
            binding.tvTotal.text=         "Total Amount :       $sumAll"
            binding.tvLunch.text= "Lunch Amount :      $sumLunch"
            binding.tvBF.text=    "BreakFast Amount :  $sumBF"
            binding.tvDinner.text="Dinner Amount:      $sumDinner"
          /*  if (list[i].typeFood.equals("LUNCH")){
                Log.d("TAG", list[i].Amount)

                sum +=list[i].Amount.toInt()
            }else{

            }
        }*/
        Log.d("TAG", "LUNCH $sumLunch")
        Log.d("TAG", "Breakfast $sumDinner")
        Log.d("TAG", " dinner$sumBF")
        Log.d("TAG", " dinner$sumAll")
    }

}