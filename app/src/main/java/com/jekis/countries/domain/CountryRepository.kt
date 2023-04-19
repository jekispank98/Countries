package com.jekis.countries.domain

import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountry
import retrofit2.Response

interface CountryRepository {

    suspend fun getCountryInfo(country: String): Response<DetailedCountry>

    suspend fun getListOfCountry(): Response<CountryName>
}