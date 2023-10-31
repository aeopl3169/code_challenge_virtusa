package com.shashi.shiva.codechallengevirtusa.data.repos

import com.shashi.shiva.codechallengevirtusa.data.network.ApiHelper
import com.shashi.shiva.codechallengevirtusa.data.network.Resource
import com.shashi.shiva.codechallengevirtusa.data.network.model.DashboardResponse
import com.shashi.shiva.codechallengevirtusa.data.prefs.PreferencesHelper
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseRepository
import com.shashi.shiva.codechallengevirtusa.utils.LoggedInMode
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    appDispatcher: DispatcherProvider,
    apiHelper: ApiHelper,
    preferencesHelper: PreferencesHelper,
) : BaseRepository(appDispatcher,apiHelper, preferencesHelper) {

    fun logout() {

        flow<Unit> {
            setUserAsLoggedOut()
        }.flowOn(getAppDispatcher().computation())

    }

    suspend fun getDashboardData(): Resource<DashboardResponse> {

        return getApiHelper().getDashboardData()

    }


    private fun setUserAsLoggedOut() {
        getPreferencesHelper().updateUserInfo(
            null,
            null,
            LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
            null,
            null,
            null
        )
    }


}