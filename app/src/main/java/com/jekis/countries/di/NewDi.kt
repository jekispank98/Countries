package com.jekis.countries.di

import com.jekis.countries.data.network.CountryRepositoryImpl
import com.jekis.countries.data.network.GetDataFromNetwork
import com.jekis.countries.data.network.GetDataFromNetworkImpl
import com.jekis.countries.data.network.model.CountryApiService
import com.jekis.countries.domain.CountryRepository
import com.jekis.countries.domain.GetCountryInfoUseCase
import com.jekis.countries.domain.GetListOfCountryUseCase
import com.jekis.countries.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://restcountries.com/v2/"
val mainModule = module {

    single<CountryApiService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    single {
        GetDataFromNetworkImpl(apiService = get())
    }

    single<CountryRepository> {
        CountryRepositoryImpl(getDataFromNetwork = get())
    }

    factory {
        GetCountryInfoUseCase(repository = get())
    }

    factory {
        GetListOfCountryUseCase(repository = get())
    }

    viewModel {
        MainViewModel(
            getCountryInfoUseCase = get(),
            getListOfCountryUseCase = get(),
            application = get()
        )
    }
}