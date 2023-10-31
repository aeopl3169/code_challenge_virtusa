package com.shashi.shiva.codechallengevirtusa.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.shashi.shiva.codechallengevirtusa.data.repos.LoginRepository
import com.shashi.shiva.codechallengevirtusa.ui.login.LoginViewModel
import com.shashi.shiva.codechallengevirtusa.ui.splash.SplashViewModel
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider


class ViewModelFactory(
    private val repository: LoginRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}