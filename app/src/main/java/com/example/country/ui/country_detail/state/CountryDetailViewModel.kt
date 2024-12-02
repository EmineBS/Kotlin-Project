package com.example.country.ui.country_detail.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.country.common.Resource
import com.example.country.domain.use_cases.GetCountryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import com.example.country.data.network.CountryNameProvider


@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryDetailUseCase: GetCountryDetailUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val countryNameProvider: CountryNameProvider
) : ViewModel() {
    private val _state = mutableStateOf(CountryDetailState())
    val state: State<CountryDetailState> = _state

    init {
        // Retrieve the country name from SavedStateHandle
        val countryName = savedStateHandle.get<String>("countryName")
            ?: countryNameProvider.getCountryName()

        getCountry(countryName)
    }

    private fun getCountry(countryName: String) {
        getCountryDetailUseCase(countryName).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = CountryDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CountryDetailState(
                        countryList = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = CountryDetailState(
                        error = result.message ?: "Unexpected error"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
