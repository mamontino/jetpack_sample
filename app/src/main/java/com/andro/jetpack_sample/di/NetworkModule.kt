package com.andro.jetpack_sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(RequestInterceptor())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("https://gist.githubusercontent.com/skydoves/aa3bbb...")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideDisneyService(retrofit: Retrofit): DisneyService {
//        return retrofit.create(DisneyService::class.java)
//    }
}