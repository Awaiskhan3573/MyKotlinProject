package com.note.app.mykotlinproject.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.note.app.mykotlinproject.R
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesActivity : AppCompatActivity() {
    private val TAG: String="Kotlin"
//    lateinit var counterText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

    CoroutineScope(Dispatchers.IO).launch{
        printFbFollower()

    }
// suspened function
//    CoroutineScope(Dispatchers.Main).launch {
//        task1()
//    }
//    CoroutineScope(Dispatchers.Main).launch {
//        task2()
//    }
//        counterText=findViewById(R.id.tvCount)
//        Log.d(TAG,"${Thread.currentThread().name}")

    }
//    fun updateCounter(view:View){
//        Log.d(TAG,"${Thread.currentThread().name}")
//        counterText.text="${counterText.text.toString().toInt() + 1}"
//    }
//   private fun longExcuteableTask(){
//        for(i in 1..1000000000L){
//
//        }
//    }
//    fun doAction(view: View) {
//       CoroutineScope(Dispatchers.IO).launch {
//           Log.d(TAG,"1-${Thread.currentThread().name}")
//       }
//        GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG,"2-${Thread.currentThread().name}")
//        }
//        MainScope().launch(Dispatchers.Default) {
//            Log.d(TAG,"3-${Thread.currentThread().name}")
//        }
//    }

//   suspend fun task1(){
//        Log.d(TAG,"Task 1 start")
//        yield()
//        Log.d(TAG,"Task 1 ended")
//
//    }
//    suspend fun task2(){
//        Log.d(TAG,"Task 2 start")
//        yield()
//        Log.d(TAG,"Task 2 ended")
//
//    }

//    using job
//   suspend fun printFbFollower(){
//       var fbfollow=0
//   val job= CoroutineScope(Dispatchers.IO).launch {
//        fbfollow=fbFollower()
//    }
//    job.join()
//    Log.d(TAG,fbfollow.toString())
//
//    }
//   suspend fun fbFollower():Int{
//        delay(1000)
//        return 34
//
//    }
    suspend fun printFbFollower(){

        val fb= CoroutineScope(Dispatchers.IO).async {
            fbFollower()

        }
    val insta= CoroutineScope(Dispatchers.IO).async {
        instaFollower()
    }

        Log.d(TAG,"FB-${fb.await()},INSTA-${insta.await()}")

    }
    suspend fun fbFollower():Int{
        delay(1000)
        return 34

    }
    suspend fun instaFollower():Int{
        delay(1000)
        return 114

    }
}