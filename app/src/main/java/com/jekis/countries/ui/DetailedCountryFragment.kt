package com.jekis.countries.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jekis.countries.databinding.FragmentDetailedCountryBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailedCountryFragment : Fragment() {
    private val viewModel: MainViewModel by sharedViewModel()
    private var _binding: FragmentDetailedCountryBinding? = null
    val binding get() = _binding!!

    private var country: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        country?.let { viewModel.getCountryInfoData(it) }
        _binding = FragmentDetailedCountryBinding.inflate(inflater, container, false)
        val glide = Glide.with(this)
        binding.tvName.text = country
        viewModel.listOfCountryInfo.observe(viewLifecycleOwner) {

            val flagCode = it.body()?.get(0)?.flags?.png
            binding.apply {
                glide.load(flagCode).into(binding.tvFlag)
                tvContinent.text = it.body()?.get(0)?.region
                tvCapital.text = it.body()?.get(0)?.capital
                tvCurrency.text = it.body()?.get(0)?.currencies?.get(0)?.name
                tvTimeZone.text = it.body()?.get(0)?.timezones.toString()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val ARG_PARAM = "countryName"
    }

    private fun getData() {
        arguments?.let {
            country = it.getString(ARG_PARAM).toString()
        }
    }
}