package com.shashi.shiva.codechallengevirtusa.ui.base

import com.shashi.shiva.codechallengevirtusa.data.network.ApiHelper
import com.shashi.shiva.codechallengevirtusa.data.prefs.PreferencesHelper
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider


open class BaseRepository(
    private val appDispatcher: DispatcherProvider,
    private val apiHelper: ApiHelper,
    private val preferencesHelper: PreferencesHelper
) {

    fun getAppDispatcher(): DispatcherProvider {
        return appDispatcher
    }

    fun getApiHelper(): ApiHelper {

        return apiHelper
    }

    fun getPreferencesHelper(): PreferencesHelper {
        return preferencesHelper
    }

    fun getUserId(): String {
        return getPreferencesHelper().getCurrentUserId() ?: ""

    }


}