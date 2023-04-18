package com.jekis.countries.data.network.model

import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountryItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryApiService {
    @GET("all?fields=name,flags")
    suspend fun getAllCountryName(): Response<CountryName>
    @GET("name/:country?fields=flags,capital,region,currencies,timezones")
    suspend fun getCountryInfo(country: String): Response<DetailedCountryItem>
}