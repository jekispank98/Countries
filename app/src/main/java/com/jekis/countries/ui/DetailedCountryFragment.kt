package com.jekis.countries.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jekis.countries.databinding.FragmentDetailedCountryBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailedCountryFragment : Fragment() {
    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentDetailedCountryBinding
    private var country: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MainViewModel", "Variable country is $country")
        country?.let { viewModel.getCountryInfoData(it) }
        binding = FragmentDetailedCountryBinding.inflate(inflater, container, false)
        val glide = Glide.with(this)
        binding.tvName.text = country
        viewModel.listOfCountryInfo.observe(viewLifecycleOwner) {
            binding.apply {
                glide.load(it.body()?.flags?.svg).into(binding.tvFlag)
                tvContinent.text = it.body()?.region
                tvCapital.text = it.body()?.capital
                tvCurrency.text = it.body()?.currencies.toString()
                tvTimeZone.text = it.body()?.timezones.toString()
            }
        }

        return binding.root
    }

    companion object {
        private const val ARG_PARAM = "countryName"
       }

    private fun getData(){
        arguments?.let {
            country = it.getString(ARG_PARAM).toString()
        }
    }
}