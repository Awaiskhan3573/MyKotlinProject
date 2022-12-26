package com.note.app.mykotlinproject.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.note.app.mykotlinproject.roomdatabase.database.DataDao
import com.note.app.mykotlinproject.roomdatabase.model.DataModel

@Database(entities = [Quote::class, DataModel::class],version = 3)
abstract class QuoteDatabase : RoomDatabase(){
    abstract fun quoteDao():QuoteDao
    abstract fun dataDao(): DataDao
    companion object{
        private var INSTANCE :QuoteDatabase? = null
        fun getDatabase(context:Context):QuoteDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quoteDB "
                    )   .createFromAsset("quotes.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}