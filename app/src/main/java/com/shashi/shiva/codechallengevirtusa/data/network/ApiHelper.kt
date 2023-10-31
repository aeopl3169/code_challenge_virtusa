package com.shashi.shiva.codechallengevirtusa.data.network

import com.shashi.shiva.codechallengevirtusa.data.network.model.DashboardResponse
import com.shashi.shiva.codechallengevirtusa.data.network.model.LoginResponse


interface ApiHelper {

    fun getApiHeader(): ApiHeader?
    fun updateToken(token: String)
    fun login(email: String, password: String): Resource<LoginResponse>

    suspend fun getDashboardData(): Resource<DashboardResponse>
}
