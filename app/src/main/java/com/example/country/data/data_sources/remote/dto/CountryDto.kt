package com.example.country.data.data_sources.remote.dto

import com.example.country.domain.models.Country
import com.example.country.domain.models.Currency


data class CountryDto(
    val gdp: Double,
    val sex_ratio: Double,
    val surface_area: Double,
    val life_expectancy_male: Double,
    val unemployment: Double,
    val imports: Double,
    val homicide_rate: Double,
    val currency: CurrencyDto,
    val iso2: String,
    val employment_services: Double,
    val employment_industry: Double,
    val urban_population_growth: Double,
    val secondary_school_enrollment_female: Double,
    val employment_agriculture: Double,
    val capital: String,
    val forested_area: Double,
    val tourists: Double,
    val exports: Double,
    val life_expectancy_female: Double,
    val post_secondary_enrollment_female: Double,
    val post_secondary_enrollment_male: Double,
    val primary_school_enrollment_female: Double,
    val infant_mortality: Double,
    val gdp_growth: Double,
    val threatened_species: Double,
    val population: Double,
    val urban_population: Double,
    val secondary_school_enrollment_male: Double,
    val name: String,
    val pop_growth: Double,
    val region: String,
    val pop_density: Double,
    val internet_users: Double,
    val gdp_per_capita: Double,
    val fertility: Double,
    val refugees: Double,
    val primary_school_enrollment_male: Double
)

data class CurrencyDto(
    val code: String,
    val name: String
)

fun CountryDto.toCountry(): Country {
    return Country(
        name = this.name,
        capital = this.capital,
        region = this.region,
        gdp = this.gdp,
        sexRatio = this.sex_ratio,
        surfaceArea = this.surface_area,
        lifeExpectancyMale = this.life_expectancy_male,
        unemployment = this.unemployment,
        imports = this.imports,
        homicideRate = this.homicide_rate,
        currency = this.currency.toCurrency(),  // Assuming a conversion function for CurrencyDto
        iso2 = this.iso2,
        employmentServices = this.employment_services,
        employmentIndustry = this.employment_industry,
        urbanPopulationGrowth = this.urban_population_growth,
        secondarySchoolEnrollmentFemale = this.secondary_school_enrollment_female,
        employmentAgriculture = this.employment_agriculture,
        forestedArea = this.forested_area,
        tourists = this.tourists,
        exports = this.exports,
        lifeExpectancyFemale = this.life_expectancy_female,
        postSecondaryEnrollmentFemale = this.post_secondary_enrollment_female,
        postSecondaryEnrollmentMale = this.post_secondary_enrollment_male,
        primarySchoolEnrollmentFemale = this.primary_school_enrollment_female,
        infantMortality = this.infant_mortality,
        gdpGrowth = this.gdp_growth,
        threatenedSpecies = this.threatened_species,
        population = this.population,
        urbanPopulation = this.urban_population,
        secondarySchoolEnrollmentMale = this.secondary_school_enrollment_male,
        popGrowth = this.pop_growth,
        popDensity = this.pop_density,
        internetUsers = this.internet_users,
        gdpPerCapita = this.gdp_per_capita,
        fertility = this.fertility,
        refugees = this.refugees,
        primarySchoolEnrollmentMale = this.primary_school_enrollment_male
    )
}

fun CurrencyDto.toCurrency(): Currency {
    return Currency(
        code = code,
        name = name
    )
}

