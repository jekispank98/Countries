package com.jekis.countries.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jekis.countries.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: MainFragmentAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getListOfCountryData()
        binding = FragmentMainBinding.inflate(inflater, container, false)
        recyclerView = binding.rvListOfCountry
        adapter = MainFragmentAdapter(requireContext())
        recyclerView.adapter = adapter
        viewModel.countryList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonUpdateData.setOnClickListener {
            viewModel.getListOfCountryData()
        }
    }
}