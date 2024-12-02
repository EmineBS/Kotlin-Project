package com.example.country.data.repositories

import com.example.country.data.data_sources.remote.dto.CountryDto
//import com.example.country.data.data_sources.remote.dto.CoinDto

interface CountryRepository {
    //suspend fun getCoins():List<CoinDto>
    suspend fun getCountry(countryName: String): List<CountryDto>
}