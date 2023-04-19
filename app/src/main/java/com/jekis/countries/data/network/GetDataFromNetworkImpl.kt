package com.jekis.countries.data.network

import android.util.Log
import com.jekis.countries.data.network.model.CountryApiService
import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountry
import retrofit2.Response

class GetDataFromNetworkImpl(private val apiService: CountryApiService): GetDataFromNetwork {

    override suspend fun getListOfCountry(): Response<CountryName> {
        return apiService.getAllCountryName()
    }

    override suspend fun getCountryInfo(country:String): Response<DetailedCountry> {
        Log.d("USECASE", "Fun in GetDataImpl is started with $country")
        return apiService.getCountryInfo(country)
    }
}