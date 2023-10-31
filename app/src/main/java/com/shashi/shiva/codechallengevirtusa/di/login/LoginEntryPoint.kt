package com.shashi.shiva.codechallengevirtusa.di.login

import com.shashi.shiva.codechallengevirtusa.data.repos.LoginRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(LoginComponent::class)
interface LoginEntryPoint {
    fun getLoginRepo(): LoginRepository
}