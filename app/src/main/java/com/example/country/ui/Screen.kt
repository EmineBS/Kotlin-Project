package com.example.country.ui

sealed class Screen(val route:String) {
    data object CountryListScreen : Screen("country_list_screen")
    data object CountryDetailScreen : Screen("country_detail_screen/{countryName}") {
        fun createRoute(countryName: String) = "country_detail_screen/$countryName"
    }
}