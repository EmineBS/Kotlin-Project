package com.example.country.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.rememberNavController
import com.example.country.common.Constants
import com.example.country.ui.country_detail.ui_elements.CountryDetailScreen
import com.example.country.ui.country_list.ui_elements.CountryListScreen
import com.example.country.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.country.data.network.CountryNameProvider


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val countryNameProvider = CountryNameProvider()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CountryListScreen.route
                    ) {
                        composable(
                            route = Screen.CountryListScreen.route
                        ) {
                            CountryListScreen(navController, countryNameProvider)
                        }
                        composable(
                            route = Screen.CountryDetailScreen.route,
                            arguments = listOf(
                                navArgument("countryName") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val countryName = backStackEntry.arguments?.getString("countryName")
                            CountryDetailScreen(navController=navController, countryName=countryName)
                        }
                    }
                }
            }
        }
    }
}