package com.jekis.countries.ui.main

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jekis.countries.model.CountryName
import com.jekis.countries.network.CountryApi
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _dataList = MutableLiveData<Response<CountryName>>()
    val dataList: LiveData<Response<CountryName>> = _dataList

    init {
        getDataFromApi()
    }

    fun getDataFromApi() {
        viewModelScope.launch {
            try {
                val result = CountryApi.retrofitService.getAllCountryName()
                Log.d("ViewModel", "$result")
                _dataList.value = result
            } catch (e: Exception) {
                Toast.makeText(
                    getApplication(),
                    "Something wrong with load data, try again!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}