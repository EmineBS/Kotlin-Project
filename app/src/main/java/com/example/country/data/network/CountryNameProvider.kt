package com.example.country.data.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryNameProvider @Inject constructor() {
    private var currentCountryName: String = "DefaultCountry"

    fun setCountryName(countryName: String) {
        currentCountryName = countryName
    }

    fun getCountryName(): String {
        return currentCountryName
    }
}