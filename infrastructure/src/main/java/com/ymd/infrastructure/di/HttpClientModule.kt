package com.ymd.infrastructure.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ymd.infrastructure.manager.CategoryEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HttpClientModule {
    private val URL_BASE = "https://api.chucknorris.io/jokes/"
    private val REQUEST_TIMEOUT = 10

    @Singleton
    @Provides
    fun provideGsonCreate(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder().connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpClientBuilder.cache(null).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideCategoryEndpoint(retrofit: Retrofit): CategoryEndpoint {
        return retrofit.create(CategoryEndpoint::class.java)
    }

}