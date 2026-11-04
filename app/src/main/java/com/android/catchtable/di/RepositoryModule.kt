package com.android.catchtable.di

import com.android.catchtable.data.repositoryimpl.HomeRepositoryImpl
import com.android.catchtable.data.repositoryimpl.RestaurantRepositoryImpl
import com.android.catchtable.data.repositoryimpl.TogetherRepositoryImpl
import com.android.catchtable.domain.repository.HomeRepository
import com.android.catchtable.domain.repository.RestaurantRepository
import com.android.catchtable.domain.repository.TogetherRepository
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
    abstract fun bindRestaurantRepository(impl: RestaurantRepositoryImpl): RestaurantRepository

    @Binds
    @Singleton
    abstract fun bindTogetherRepository(impl: TogetherRepositoryImpl): TogetherRepository
}
