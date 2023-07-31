package com.marcosdev.sustitutorio_titoquispe_estadocovid

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

object ServiceGenerator {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid-19.dataflowkit.com/")
        .addConverterFactory(GsonConverterFactory.create())


    interface ApiService {
        @GET("v1")
        fun getResults() : Call<List<ResModelItem>>
    }

    fun build() : ApiService{
        return retrofit.build().create(ApiService::class.java)
    }
}