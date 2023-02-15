package com.jekis.countries.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jekis.countries.R
import com.jekis.countries.databinding.FragmentDetailedCountryBinding

class DetailedCountryFragment : Fragment() {
    private lateinit var binding: FragmentDetailedCountryBinding
    private var country: String? = null
    private var flagUrl: String? = null
    private var capital: String? = null
    private var region: String? = null
    private var currency: String? = null
    private var timeZone: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailedCountryBinding.inflate(inflater, container, false)
        Glide.with(this).load(flagUrl).into(binding.tvFlag)
        binding.apply {
            tvName.text = country
            tvContinent.text = region
            tvCapital.text = capital
            tvCurrency.text = currency
            tvTimeZone.text = timeZone }
        return binding.root
    }

    companion object {
        private const val ARG_PARAM = "countryName"
        private const val FLAG_URL = "flagUrl"
        private const val CAPITAL = "capital"
        private const val REGION = "region"
        private const val CURRENCY = "currency"
        private const val TIME_ZONE = "timeZone"
       }

    private fun getData(){
        arguments?.let {
            country = it.getString(ARG_PARAM).toString()
            flagUrl = it.getString(FLAG_URL).toString()
            capital = it.getString(CAPITAL).toString()
            region = it.getString(REGION).toString()
            currency = it.getString(CURRENCY).toString()
            timeZone = it.getString(TIME_ZONE).toString()

        }
    }
}