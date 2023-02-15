package com.jekis.countries.model

import com.google.gson.JsonObject

data class CountryNameItem(
    val independent: Boolean,
    val name: String,
    val flags: Flags,
    val capital: String,
    val currencies: List<Currency>,
    val region: String,
    val timezones: List<String>
)