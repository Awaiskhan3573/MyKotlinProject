package com.note.app.mykotlinproject.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import com.note.app.myfirstapp.currencyconverter.model.Country
import com.note.app.mykotlinproject.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerBinding
    var list = ArrayList<Country>()
    var strList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        list.add(Country("country1", "PKR", "56"))
        list.add(Country("country1", "IND ", "56"))
        list.add(Country("country1", "Su", "56"))
        list.add(Country("country1", "NEW", "56"))
        list.add(Country("country1", "AFG", "56"))
        list.add(Country("country1", "SRI", "56"))
        list.add(Country("country1", "PKR", "56"))
        list.add(Country("country1", "PKR", "56"))
        list.add(Country("country1", "PKR", "56"))
        list.add(Country("country1", "PKR", "56"))



        for (i in 0 until list.size) {
            strList.add(list[i].symbol)

        }
        // access the spinner

        if (binding.spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, strList
            )
           /* adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            val ll = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            ll.setMargins(10, 40, 10, 10)*/
            binding.spinner.adapter=adapter
            binding.spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(this@SpinnerActivity,"selected item is : ${strList[p2]}",Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        }
    }
}