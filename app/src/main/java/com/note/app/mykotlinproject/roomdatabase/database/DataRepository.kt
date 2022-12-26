package com.note.app.mykotlinproject.roomdatabase.database

import androidx.lifecycle.LiveData
import com.note.app.mykotlinproject.roomdatabase.model.DataModel

class DataRepository (private val dataDao: DataDao) {

    fun getData(): LiveData<List<DataModel>> {
        return dataDao.getData()
    }

    suspend fun insertData(dataModel: DataModel) {
        dataDao.insertData(dataModel)
    }
}