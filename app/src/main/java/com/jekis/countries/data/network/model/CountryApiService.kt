package com.jekis.countries.data.network.model

import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountry
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CountryApiService {
    @GET("all?fields=name,flags")
    suspend fun getAllCountryName(): Response<CountryName>
    @GET("name/{country}?fields=flags,capital,region,currencies,timezones")
    suspend fun getCountryInfo(@Path("country")country: String): Response<DetailedCountry>
}