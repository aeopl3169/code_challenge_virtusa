package com.shashi.shiva.codechallengevirtusa.di

import com.shashi.shiva.codechallengevirtusa.data.network.ApiHelper
import com.shashi.shiva.codechallengevirtusa.data.network.AppApiHelper
import com.shashi.shiva.codechallengevirtusa.data.prefs.AppPreferencesHelper
import com.shashi.shiva.codechallengevirtusa.data.prefs.PreferencesHelper
import com.shashi.shiva.codechallengevirtusa.ui.base.BaseRepository
import com.shashi.shiva.codechallengevirtusa.data.repos.DashboardRepository
import com.shashi.shiva.codechallengevirtusa.utils.PREF_NAME
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.AppDispatcherProvider
import com.shashi.shiva.codechallengevirtusa.utils.coroutines.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object{
        @Provides
        @PreferenceInfo
        fun providePreferenceName(): String {
            return PREF_NAME
        }

        @Provides
        @EmptyString
        fun provideApiKey(): String {
            return ""
        }

    }

    @Binds
    @Singleton
    abstract fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper

    @Binds
    @Singleton
    abstract fun providePreferenceHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper


    @Binds
    @Singleton
    abstract fun provideDispatcher(dispatcherProvider: AppDispatcherProvider): DispatcherProvider

    @Binds
    @Singleton
    abstract fun provideDashboardRepo(dashboardRepository: DashboardRepository): BaseRepository

}