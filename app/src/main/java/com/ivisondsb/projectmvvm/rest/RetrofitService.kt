package com.ivisondsb.projectmvvm.rest

import com.ivisondsb.projectmvvm.models.Lives
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("lista-lives.json")
    fun getAllLives(): Call<List<Lives>>

    companion object {
        private val retrofitService: RetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance(): RetrofitService {
            return retrofitService
        }

    }
}