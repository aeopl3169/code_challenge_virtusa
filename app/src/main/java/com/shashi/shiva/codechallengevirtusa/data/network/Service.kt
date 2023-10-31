package com.shashi.shiva.codechallengevirtusa.data.network


import com.shashi.shiva.codechallengevirtusa.data.network.model.*
import retrofit2.Response
import retrofit2.http.*


interface Service {

    @POST("login")
     fun login(@Body request: LoginRequest): Response<LoginResponse>


    @GET("dashboard")
    suspend fun getDashboardData():Response<DashboardResponse>


}
