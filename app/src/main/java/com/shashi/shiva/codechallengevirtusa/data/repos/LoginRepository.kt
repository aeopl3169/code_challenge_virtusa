package com.shashi.shiva.codechallengevirtusa.data.repos

import com.shashi.shiva.codechallengevirtusa.data.network.ApiHelper
import com.shashi.shiva.codechallengevirtusa.data.network.DataError
import com.shashi.shiva.codechallengevirtusa.data.network.Resource
import com.shashi.shiva.codechallengevirtusa.data.network.model.LoginResponse
import com.shashi.shiva.codechallengevirtusa.data.prefs.PreferencesHelper
import com.shashi.shiva.codechallengevirtusa.di.login.LoginScope
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseRepository
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.AppDispatcherProvider
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@LoginScope
class LoginRepository @Inject constructor(
    appDispatcherProvider: DispatcherProvider,
    apiHelper: ApiHelper,
    preferencesHelper: PreferencesHelper,
) : BaseRepository(appDispatcherProvider,apiHelper, preferencesHelper) {


    fun login(email: String, password: String): Flow<Resource<LoginResponse>> {
        val loginResult = getApiHelper().login(email, password)

        loginResult.data?.let {
            if (it.status) {
                val loginResponse = loginResult.data

                if (loginResponse.status) {
                    val userId = loginResponse.data.userId
                    val token = loginResponse.data.token
                    val userType = loginResponse.data.userType

                    getPreferencesHelper().setUserLoggedIn(
                        userId = userId,
                        userName = userType,
                        email = userId, accessToken = token
                    )
                    getApiHelper().updateToken(token)

                }
            } else {
                return flow {
                    emit(DataError(loginResult.data.message))
                }
            }
        }

        return flow {
            emit(loginResult)
        }
    }

    suspend fun isUserLoggedIn(): Flow<Int?> {

        return flow {
            delay(3000)

            emit(getPreferencesHelper().getCurrentUserLoggedInMode())
        }.flowOn(getAppDispatcher().computation())

    }



}