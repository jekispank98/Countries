package com.jekis.countries.domain

import com.jekis.countries.data.network.CountryRepositoryImpl
import com.jekis.countries.domain.model.CountryName
import retrofit2.Response

class GetListOfCountryUseCase(private val repository: CountryRepository) {

    suspend fun getListOfCountry(): Response<CountryName> {
        return repository.getListOfCountry()
    }

}