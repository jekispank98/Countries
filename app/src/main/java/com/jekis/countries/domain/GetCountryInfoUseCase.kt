package com.jekis.countries.domain

import android.util.Log
import com.jekis.countries.domain.model.DetailedCountry
import com.jekis.countries.domain.model.DetailedCountryItem
import retrofit2.Response

class GetCountryInfoUseCase(private val repository: CountryRepository) {

    suspend fun getCountryInfo(country: String): Response<DetailedCountryItem> {
        Log.d("USECASE", "Fun in UseCase is started")
        return repository.getCountryInfo(country)

    }
}