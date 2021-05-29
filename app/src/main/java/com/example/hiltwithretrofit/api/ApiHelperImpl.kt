package com.example.hiltwithretrofit.api

import com.example.hiltwithretrofit.others.PokeResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper{
    override suspend fun getEmployees(): Response<PokeResponse> = apiService.getEmployees()
}
