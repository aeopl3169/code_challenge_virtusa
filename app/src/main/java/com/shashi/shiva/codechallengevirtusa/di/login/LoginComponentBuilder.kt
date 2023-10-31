package com.shashi.shiva.codechallengevirtusa.di.login

import com.shashi.shiva.codechallengevirtusa.data.repos.LoginRepository
import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface LoginComponentBuilder {
    fun bindLoginRepo(@BindsInstance loginRepository: LoginRepository): LoginComponentBuilder
    fun build(): LoginComponent?
}