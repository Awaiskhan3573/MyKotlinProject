package com.note.app.myfirstapp.location.callBack

import android.graphics.Point

interface SearchLocation {
    fun getSearchLocation(point: Point, placeName:String)
}