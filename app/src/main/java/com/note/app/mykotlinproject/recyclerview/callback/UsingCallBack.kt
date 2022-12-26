package com.note.app.mykotlinproject.recyclerview.callback

import android.graphics.ColorSpace
import com.note.app.mykotlinproject.recyclerview.Model

interface UsingCallBack {
    fun onClickItem(model:Model,position:Int)
}