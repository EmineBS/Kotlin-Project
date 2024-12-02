package com.example.country.di

import com.example.country.common.Constants
import com.example.country.data.repositories.CountryRepository
import com.example.country.data.repositories.CountryRepositoryImpl
import com.example.country.data.data_sources.remote.CountriesApi
import com.example.country.data.network.CountryNameProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryNameInterceptor(
        countryNameProvider: CountryNameProvider
    ): Interceptor = Interceptor { chain ->
        val countryName = countryNameProvider.getCountryName()
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("X-Api-Key", Constants.API_KEY)
            .addHeader("name", countryName)
            .build()
        chain.proceed(modifiedRequest)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        countryNameInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(countryNameInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCountriesApi(
        retrofit: Retrofit
    ): CountriesApi = retrofit.create(CountriesApi::class.java)

    @Provides
    @Singleton
    fun provideCountryRepository(
        api: CountriesApi
    ): CountryRepository = CountryRepositoryImpl(api)
}