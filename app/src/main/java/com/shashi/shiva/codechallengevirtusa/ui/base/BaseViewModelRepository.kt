package com.shashi.shiva.codechallengevirtusa.ui.base

import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider


open class BaseViewModelRepository<T:BaseRepository>(repo : T )
    : BaseViewModel<T>(repo){


        fun getRepository() : T{

            return anyType
        }


}