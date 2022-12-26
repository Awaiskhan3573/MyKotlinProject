package com.note.app.mykotlinproject.roomdatabase.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainViewModelDataFactory (private val dataRepository: DataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  MainViewModelData(dataRepository) as T
    }

}