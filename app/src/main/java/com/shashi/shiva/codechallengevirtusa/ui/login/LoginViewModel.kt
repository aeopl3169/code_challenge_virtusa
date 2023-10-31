package com.shashi.shiva.codechallengevirtusa.ui.login

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.Companion.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shashi.shiva.codechallengevirtusa.data.network.DataError
import com.shashi.shiva.codechallengevirtusa.data.network.Resource
import com.shashi.shiva.codechallengevirtusa.data.network.model.LoginResponse
import com.shashi.shiva.codechallengevirtusa.data.repos.LoginRepository
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseViewModel
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseViewModelRepository
import com.shashi.shiva.codechallengevirtusa.utils.ENTER_EMAIL_ID
import com.shashi.shiva.codechallengevirtusa.utils.ENTER_PASSWORD
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class LoginViewModel (
    loginRepository: LoginRepository,
) : BaseViewModelRepository<LoginRepository>(loginRepository) {



    @VisibleForTesting(otherwise = PRIVATE)
    val loginResponsePrivate = MutableLiveData<Resource<LoginResponse>>()
    val loginResponse: LiveData<Resource<LoginResponse>> get() = loginResponsePrivate



    fun onSignInBtnClick(email: String, password: String) {

        when {
            email.isEmpty() -> {
                showMessageDialog(DataError(ENTER_EMAIL_ID))
            }
            password.isEmpty() -> {
                showMessageDialog(DataError(ENTER_PASSWORD))

            }
            else -> {
                showLoading()

                viewModelScope.launch(exceptionHandler) {

                    getRepository().login(email, password)
                        .collect { loginResult ->
                            hideLoading()

                            if (loginResult.data != null) {
                                loginResponsePrivate.value = loginResult
                            } else {
                                showMessageDialog(loginResult as DataError<String>)
                            }

                        }

                }



            }
        }

    }




}
