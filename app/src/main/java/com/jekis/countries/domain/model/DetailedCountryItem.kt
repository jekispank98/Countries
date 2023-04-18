package com.jekis.countries.domain.model

data class DetailedCountryItem(
    val capital: String,
    val currencies: List<Currency>,
    val flags: Flags,
    val independent: Boolean,
    val region: String,
    val timezones: List<String>
)