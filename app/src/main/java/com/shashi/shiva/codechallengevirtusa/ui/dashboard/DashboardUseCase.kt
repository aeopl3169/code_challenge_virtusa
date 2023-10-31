package com.shashi.shiva.codechallengevirtusa.ui.dashboard

import com.shashi.shiva.codechallengevirtusa.data.network.Resource
import com.shashi.shiva.codechallengevirtusa.data.network.model.DashboardResponse
import com.shashi.shiva.codechallengevirtusa.data.repos.DashboardRepository
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseUseCase
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    appDispatcher: DispatcherProvider,
    dashboardRepository: DashboardRepository
) : BaseUseCase<DashboardRepository>(dashboardRepository, appDispatcher) {
//add dashboard business logic
    suspend fun getDashboardData(): Resource<DashboardResponse> {

        return getRepository().getDashboardData()
    }

    fun getUserId(): String {

        return getRepository().getUserId()
    }

    fun logout(){
        getRepository().logout()


    }


}