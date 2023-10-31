package com.shashi.shiva.codechallengevirtusa.ui.base

import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider


open class BaseViewModelUseCase<T>(private val useCase: T)
    : BaseViewModel<T>(useCase){


        fun getUseCase() : T{

            return useCase
        }


}