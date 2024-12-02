package com.example.country.ui.country_detail.state

import com.example.country.domain.models.Country

data class CountryDetailState(
    val isLoading: Boolean = false,
    val countryList: List<Country> = emptyList(),
    val error: String = ""
)