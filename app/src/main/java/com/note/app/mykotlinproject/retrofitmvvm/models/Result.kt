package com.note.app.mykotlinproject.retrofitmvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Result(


    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,

)