package com.example.hiltwithretrofit.api

import com.example.hiltwithretrofit.others.PokeResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService{
    @GET("pokemon?limit=100&offset=200")
    suspend fun getEmployees(): Response<PokeResponse>
}