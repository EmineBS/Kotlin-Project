package com.example.country.data.data_sources.remote

import com.example.country.domain.models.Country
import com.example.country.data.data_sources.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApi {
    @GET("v1/country")
    suspend fun getCountry(@Query("name") countryName: String): List<CountryDto>

}