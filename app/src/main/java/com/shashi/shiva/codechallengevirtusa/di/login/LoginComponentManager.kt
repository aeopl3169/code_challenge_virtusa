package com.shashi.shiva.codechallengevirtusa.di.login

import com.shashi.shiva.codechallengevirtusa.data.network.ApiHelper
import com.shashi.shiva.codechallengevirtusa.data.prefs.PreferencesHelper
import com.shashi.shiva.codechallengevirtusa.data.repos.LoginRepository
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.AppDispatcherProvider
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class LoginComponentManager @Inject constructor(
    private val appDispatcherProvider: DispatcherProvider,
    private val loginComponentProvider: Provider<LoginComponentBuilder>,
    private val apiHelper: ApiHelper,
    private val preferencesHelper: PreferencesHelper,
)
{

    var loginComponent: LoginComponent? = null


    fun getComponent():LoginComponent{
        if(loginComponent==null){
            val loginRepository = LoginRepository(appDispatcherProvider, apiHelper, preferencesHelper)
            loginComponent=  loginComponentProvider.get().bindLoginRepo(loginRepository).build()

        }

        return loginComponent!!
    }

    fun destroyLoginComponent() {
        loginComponent = null
    }
}


