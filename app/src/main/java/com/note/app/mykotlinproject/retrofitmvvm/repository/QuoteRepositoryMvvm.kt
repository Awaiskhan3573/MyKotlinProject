package com.note.app.mykotlinproject.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.note.app.mykotlinproject.retrofitmvvm.api.QuoteService
import com.note.app.mykotlinproject.retrofitmvvm.models.QuoteList

class QuoteRepositoryMvvm(private val quoteService: QuoteService){
    private val quotesLiveData= MutableLiveData<QuoteList>()
    val quotes:LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page:Int){
        val result=quoteService.getQuotes(page)
        if (result?.body() != null){

            quotesLiveData.postValue(result.body())

        }
    }
}