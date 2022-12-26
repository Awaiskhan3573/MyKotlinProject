package com.note.app.myfirstapp.currencyconverter.model

data class CountryListModel(
    val code: Int,
    val `data`: Data,
    val errors: List<Any>,
    val message: String
)