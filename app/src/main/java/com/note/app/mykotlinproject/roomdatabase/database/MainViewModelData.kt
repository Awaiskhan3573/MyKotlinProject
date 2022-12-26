package com.note.app.mykotlinproject.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.note.app.mykotlinproject.roomdatabase.model.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelData (private  val dataRepository: DataRepository): ViewModel() {
    fun getData(): LiveData<List<DataModel>> {
        return dataRepository.getData()
    }
    fun insertData(dataModel: DataModel){
        viewModelScope.launch(Dispatchers.IO){
            dataRepository.insertData(dataModel)
        }


    }

}