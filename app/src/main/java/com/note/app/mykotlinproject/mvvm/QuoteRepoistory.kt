package com.note.app.mykotlinproject.mvvm

import androidx.lifecycle.LiveData

class QuoteRepoistory(private val quoteDao: QuoteDao) {

    fun getQuotes(page: Int): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }
    suspend fun insertQuote(quote: Quote?){
        quoteDao.insertQuote(quote)
    }

}