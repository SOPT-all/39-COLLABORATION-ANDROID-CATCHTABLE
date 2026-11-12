package com.android.catchtable.di

import com.android.catchtable.data.repositoryimpl.HomeRepositoryImpl
import com.android.catchtable.data.repositoryimpl.StoreRepositoryImpl
import com.android.catchtable.data.repositoryimpl.VoteRepositoryImpl
import com.android.catchtable.domain.repository.HomeRepository
import com.android.catchtable.domain.repository.StoreRepository
import com.android.catchtable.domain.repository.VoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindStoreRepository(impl: StoreRepositoryImpl): StoreRepository

    @Binds
    @Singleton
    abstract fun bindVoteRepository(impl: VoteRepositoryImpl): VoteRepository
}
