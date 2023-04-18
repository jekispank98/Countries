package com.jekis.countries.data.network

import com.jekis.countries.data.network.model.CountryApiService
import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountryItem
import retrofit2.Response

class GetDataFromNetworkImpl(private val apiService: CountryApiService): GetDataFromNetwork {

    override suspend fun getListOfCountry(): Response<CountryName> {
        return apiService.getAllCountryName()
    }

    override suspend fun getCountryInfo(country:String): Response<DetailedCountryItem> {
        return apiService.getCountryInfo(country)
    }
}