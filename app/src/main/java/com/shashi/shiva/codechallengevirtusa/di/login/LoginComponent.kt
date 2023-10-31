package com.shashi.shiva.codechallengevirtusa.di.login

import com.shashi.shiva.codechallengevirtusa.di.login.LoginScope
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@LoginScope
@DefineComponent(parent = SingletonComponent::class)
interface LoginComponent {
}