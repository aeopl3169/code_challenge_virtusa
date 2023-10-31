package com.shashi.shiva.codechallengevirtusa.ui.base

import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider

open class BaseUseCase<R:BaseRepository>( private val repository: R, private val appDispatcher: DispatcherProvider) {
// add any common business logic

    fun getRepository():R{
        return repository
    }

    fun getAppDispatcher(): DispatcherProvider {
        return appDispatcher
    }

}