package com.example.hiltwithretrofit.repository

import com.example.hiltwithretrofit.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getEmployee() = apiHelper.getEmployees()
}