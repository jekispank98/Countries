package com.jekis.countries.data.network

import android.util.Log
import com.jekis.countries.domain.CountryRepository
import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountry
import retrofit2.Response

class CountryRepositoryImpl(private val getDataFromNetwork: GetDataFromNetworkImpl): CountryRepository {

    override suspend fun getCountryInfo(country: String): Response<DetailedCountry> {
        Log.d("USECASE", "Fun in UseCaseImpl is started")
        return getDataFromNetwork.getCountryInfo(country)
    }

    override suspend fun getListOfCountry(): Response<CountryName> {
        return getDataFromNetwork.getListOfCountry()
    }
}