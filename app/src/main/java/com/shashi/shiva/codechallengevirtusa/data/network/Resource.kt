package com.shashi.shiva.codechallengevirtusa.data.network

import com.shashi.shiva.codechallengevirtusa.utils.SOMETHING_WENT_WRONG


sealed class Resource<T>(
    val data: T? = null,
    val errorDescription: String = SOMETHING_WENT_WRONG,
) {


    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is DataError -> "Error[exception=$errorDescription]"
        }
    }

}

class Success<T>(data: T) : Resource<T>(data)
class DataError<T>(errorDescription: String) : Resource<T>(null, errorDescription)
