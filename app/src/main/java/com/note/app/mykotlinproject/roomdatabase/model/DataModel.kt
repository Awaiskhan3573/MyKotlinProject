package com.note.app.mykotlinproject.roomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataModel(
  @PrimaryKey(autoGenerate = true)
  val id: Int?,
  val PaidBy:String,
  val typeFood:String,
  val Amount:String,
  val Date:String,
  val Time:String
        )
