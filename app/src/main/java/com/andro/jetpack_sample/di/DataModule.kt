package com.andro.jetpack_sample.di

import com.andro.data.DataRepositoryImpl
import com.andro.domain.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository
}
