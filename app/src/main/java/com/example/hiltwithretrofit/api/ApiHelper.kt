package com.example.hiltwithretrofit.api

import com.example.hiltwithretrofit.others.PokeResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees(): Response<PokeResponse>
}