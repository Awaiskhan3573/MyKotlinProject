package com.note.app.mykotlinproject.roomdatabase

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.databinding.DialogeKhataAppBinding
import com.note.app.mykotlinproject.mvvm.QuoteDatabase
import com.note.app.mykotlinproject.roomdatabase.database.DataRepository
import com.note.app.mykotlinproject.roomdatabase.database.MainViewModelData
import com.note.app.mykotlinproject.roomdatabase.database.MainViewModelDataFactory
import com.note.app.mykotlinproject.roomdatabase.model.DataModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DialogeKhataApp (val mcontext: Context,val activity: KhataActivity) : Dialog(mcontext) {
    lateinit var mainViewModelData: MainViewModelData
    lateinit var binding: DialogeKhataAppBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(true)
        window!!.requestFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = DialogeKhataAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val menu = mcontext.resources.getStringArray(R.array.Menu)

        // access the spinner

        if (binding.spinner != null) {
            val adapter = ArrayAdapter(
                mcontext,
                android.R.layout.simple_spinner_item, menu
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            val ll = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            ll.setMargins(10, 40, 10, 10)

            binding.spinner.adapter = adapter
            val dao = QuoteDatabase.getDatabase(context).dataDao()
            val dataRepository = DataRepository(dao)
            val factory = MainViewModelDataFactory(dataRepository)
            mainViewModelData =
                ViewModelProvider(activity, factory).get(MainViewModelData::class.java)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val current =  LocalDateTime.now()


            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatterT = DateTimeFormatter.ofPattern("HH:mm:s")
            val formattedDate = current.format(formatter)
            val formattedTime = current.format(formatterT)

            binding.btnAdd.setOnClickListener {
                val paidBy = binding.etName.text.toString().trim()
                val amount = binding.etPrice.text.toString().trim()
                val typefood = binding.spinner.selectedItem.toString()
                Log.d("68676","-----$amount  - $paidBy --")
                mainViewModelData.insertData(
                    DataModel(
                        id = null,
                        paidBy,
                        typefood,
                        amount,
                        formattedDate,
                        formattedTime
                    )
                )
                dismiss()
            }}


        }

    }
}