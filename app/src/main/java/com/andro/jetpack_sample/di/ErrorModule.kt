package com.andro.jetpack_sample.di

import com.andro.data.ErrorMapper
import com.andro.data.ErrorMapperSource
import com.andro.domain.error.ErrorHandler
import com.andro.data.ErrorHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule {

    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorHandler: ErrorHandlerImpl): ErrorHandler

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper): ErrorMapperSource
}
