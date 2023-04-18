package com.jekis.countries.domain.model

data class CountryNameItem(
    val independent: Boolean,
    val name: String,
    val flags: Flags,
    val capital: String,
    val currencies: List<Currency>,
    val region: String,
    val timezones: List<String>
)