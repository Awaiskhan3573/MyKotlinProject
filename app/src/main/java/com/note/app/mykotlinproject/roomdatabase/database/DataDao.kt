package com.note.app.mykotlinproject.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.note.app.mykotlinproject.roomdatabase.model.DataModel

@Dao
interface DataDao {

    @Query("SELECT * from data")
    fun getData(): LiveData<List<DataModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData( dataModel:DataModel )

    @Delete
    fun delete(dataModel: DataModel)
//    @Delete
//    fun reset(dataModel: List<DataModel>)
   /* @Query("UPDATE `table name` SET text = :sText WHERE ID= :sID ")
    fun update(sID: Int, sText: String?)*/

}