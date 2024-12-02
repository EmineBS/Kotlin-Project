package com.example.country.domain.use_cases

import com.example.country.common.Resource
import com.example.country.data.repositories.CountryRepository
import com.example.country.data.data_sources.remote.dto.toCountry
import com.example.country.domain.models.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(countryName: String): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            // Assuming getCountry() returns a List<CountryDto>
            val countryDtos = repository.getCountry(countryName)
            val countryList = countryDtos.map { it.toCountry() }  // Convert List<CountryDto> to List<Country>
            emit(Resource.Success(countryList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Http error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}
