package com.jekis.countries.data.network

import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountry
import retrofit2.Response

interface GetDataFromNetwork {

    suspend fun getListOfCountry(): Response<CountryName>

    suspend fun getCountryInfo(country: String): Response<DetailedCountry>
}