package com.example.country.ui.country_list.ui_elements

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.country.ui.Screen
import com.example.country.data.network.CountryNameProvider


@Composable
fun CountryListScreen(
    navController: NavController,
    countryNameProvider: CountryNameProvider
) {
    // Static list of country names
    val countries = listOf(
        "United States", "Canada", "France", "Germany", "Japan",
        "India", "China", "Brazil", "South Africa", "Australia", "Tunisia"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(countries) { country ->
                CountryListItem(country = country, onItemClick = {
                    // Navigate to details for the selected country
                    Log.d("Navigation", "Navigating to: ${country}")
                    countryNameProvider.setCountryName(country)
                    navController.navigate(Screen.CountryDetailScreen.createRoute(country))
                })
            }
        }
    }
}

@Composable
fun CountryListItem(
    country: String,
    onItemClick: (String) -> Unit
) {
    Text(
        text = country,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(country) }
            .padding(16.dp),
        textAlign = TextAlign.Start
    )
}
