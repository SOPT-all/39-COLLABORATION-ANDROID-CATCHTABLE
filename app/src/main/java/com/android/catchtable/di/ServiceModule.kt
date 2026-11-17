package com.android.catchtable.di

import com.android.catchtable.data.remote.service.StoreService
import com.android.catchtable.data.remote.service.VoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideStoreService(retrofit: Retrofit): StoreService =
        retrofit.create(StoreService::class.java)

    @Provides
    @Singleton
    fun provideVoteService(retrofit: Retrofit): VoteService =
        retrofit.create(VoteService::class.java)
}
