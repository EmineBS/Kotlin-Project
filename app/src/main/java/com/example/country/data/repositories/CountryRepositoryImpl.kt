package com.example.country.data.repositories

import android.util.Log
import com.example.country.data.data_sources.remote.CountriesApi
import com.example.country.data.data_sources.remote.dto.CountryDto
//import com.example.country.data.data_sources.remote.dto.CoinDto
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api : CountriesApi
) : CountryRepository{

    /**override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }**/

    override suspend fun getCountry(countryName: String): List<CountryDto> {
        val response = api.getCountry(countryName)
        Log.d("API Response", response.toString()) // Log the raw response
        return response
    }
}
