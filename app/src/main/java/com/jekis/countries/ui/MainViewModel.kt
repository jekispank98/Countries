package com.jekis.countries.ui

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jekis.countries.domain.GetCountryInfoUseCase
import com.jekis.countries.domain.GetListOfCountryUseCase
import com.jekis.countries.domain.model.CountryName
import com.jekis.countries.domain.model.DetailedCountryItem
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val getCountryInfoUseCase: GetCountryInfoUseCase,
    private val getListOfCountryUseCase: GetListOfCountryUseCase,
    private val application: Application
) : ViewModel() {

    private var _countryList = MutableLiveData<Response<CountryName>>()
    val countryList: LiveData<Response<CountryName>> = _countryList

    private var _listOfCountryInfo = MutableLiveData<Response<DetailedCountryItem>>()
    val listOfCountryInfo: LiveData<Response<DetailedCountryItem>> = _listOfCountryInfo

    fun getListOfCountryData() {
        viewModelScope.launch {
            try {
                val result = getListOfCountryUseCase.getListOfCountry()
                Log.d("ViewModel", "Answer ONE is $result")
                _countryList.value = result
            } catch (e: Exception) {
                Toast.makeText(
                    application,
                    "Something wrong with load data, try again!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun getCountryInfoData(country: String) {
        viewModelScope.launch {
            try {
                Log.d("MainViewModel", "Country for sending is $country")
                val result = getCountryInfoUseCase.getCountryInfo(country)
                Log.d("ViewModel", "Answer TWO is $result")
                _listOfCountryInfo.value = result
            } catch (e: Exception) {
                Toast.makeText(
                    application,
                    "Something wrong with load data, try again!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}