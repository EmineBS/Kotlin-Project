package com.example.country.domain.models
import com.example.country.data.data_sources.remote.dto.CurrencyDto

data class Country(
    val name: String,
    val capital: String,
    val region: String,
    val gdp: Double,
    val sexRatio: Double,
    val surfaceArea: Double,
    val lifeExpectancyMale: Double,
    val unemployment: Double,
    val imports: Double,
    val homicideRate: Double,
    val currency: Currency,
    val iso2: String,
    val employmentServices: Double,
    val employmentIndustry: Double,
    val urbanPopulationGrowth: Double,
    val secondarySchoolEnrollmentFemale: Double,
    val employmentAgriculture: Double,
    val forestedArea: Double,
    val tourists: Double,
    val exports: Double,
    val lifeExpectancyFemale: Double,
    val postSecondaryEnrollmentFemale: Double,
    val postSecondaryEnrollmentMale: Double,
    val primarySchoolEnrollmentFemale: Double,
    val infantMortality: Double,
    val gdpGrowth: Double,
    val threatenedSpecies: Double,
    val population: Double,
    val urbanPopulation: Double,
    val secondarySchoolEnrollmentMale: Double,
    val popGrowth: Double,
    val popDensity: Double,
    val internetUsers: Double,
    val gdpPerCapita: Double,
    val fertility: Double,
    val refugees: Double,
    val primarySchoolEnrollmentMale: Double
)

data class Currency(
    val code: String,
    val name: String
)