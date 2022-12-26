package com.note.app.mykotlinproject.retrofitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.note.app.mykotlinproject.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class RectrofitCoroutineMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectrofit_coroutine_main)

        val quotesAPI=RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        GlobalScope.launch {
            val result=quotesAPI.getQuotes(1)
            if (result!=null){

                val quoteList=result.body()
                if (quoteList != null) {
                    quoteList.results.forEach {
                        Log.d("AWAISKHAN",it.authorSlug)
                    }
                }
            }

        }
    }
}