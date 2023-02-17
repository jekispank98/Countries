package com.jekis.countries.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jekis.countries.model.CountryName
import com.jekis.countries.network.CountryApi
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private var _dataList = MutableLiveData<Response<CountryName>>()
    val dataList: LiveData<Response<CountryName>> = _dataList

    init {
        getDataFromApi()
    }

    private fun getDataFromApi() {
        viewModelScope.launch {
            try {
                val result = CountryApi.retrofitService.getAllCountryName()
                Log.d("ViewModel", "$result")
                _dataList.value = result
            }
            catch (e: Exception) {
                Log.d("MainViewModel", "Hello from background thread! Something wrong, try Later!")
            }
        }
    }
}