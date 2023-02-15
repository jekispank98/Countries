package com.jekis.countries.network

import com.jekis.countries.model.CountryName
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://restcountries.com/v2/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface CountryApiService {

    @GET("all?fields=name,flags,region,capital,currencies,timezones")
    suspend fun getAllCountryName(): Response<CountryName>
}

object CountryApi {
    val retrofitService: CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
    }
}