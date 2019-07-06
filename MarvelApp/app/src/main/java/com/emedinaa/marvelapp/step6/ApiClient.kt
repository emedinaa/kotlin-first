package com.emedinaa.marvelapp.step6

import com.emedinaa.marvelapp.HeroResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object ApiClient {

    private val API_BASE_URL = "https://obscure-earth-55790.herokuapp.com"

    private var servicesApiInterface:ServicesApiInterface?=null


    fun build():ServicesApiInterface?{
        var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())

        var retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
            ServicesApiInterface::class.java)

        return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    //https://obscure-earth-55790.herokuapp.com/api/avengers
    interface ServicesApiInterface{
        @GET("/api/avengers/")
        fun heroes(): Call<HeroResponse>
    }
}