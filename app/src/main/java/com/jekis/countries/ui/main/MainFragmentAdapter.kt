package com.jekis.countries.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jekis.countries.R
import com.jekis.countries.model.AppGlide
import com.jekis.countries.model.CountryNameItem
import com.jekis.countries.model.Flags
import com.jekis.countries.model.GlideApp

class MainFragmentAdapter(private val context: Context) :
    RecyclerView.Adapter<MainFragmentAdapter.MainFragmentHolder>() {
    private var countryList = emptyList<CountryNameItem>()

    class MainFragmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val countryName: TextView = itemView.findViewById(R.id.tv_country_name)
        val countryFlag: ImageView = itemView.findViewById(R.id.tv_country_flag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return MainFragmentHolder(view)
    }

    override fun onBindViewHolder(holder: MainFragmentHolder, position: Int) {
        val country = countryList[position]
        val uri = country.flags.png
        Glide.with(context).load(uri).into(holder.countryFlag)
        holder.countryName.text = country.name
        holder.itemView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailedCountryFragment(
                country.name,
                uri,
                country.capital,
                country.region,
                country.currencies[0].name,
                country.timezones[0]
            )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CountryNameItem>) {
        countryList = list
        notifyDataSetChanged()
    }
}