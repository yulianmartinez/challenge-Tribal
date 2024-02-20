package com.ymd.infrastructure.di

import com.ymd.domain.repository.CategoryRepository
import com.ymd.domain.services.CategoryService
import com.ymd.infrastructure.manager.ApiManager
import com.ymd.infrastructure.repository.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CategoryModule {

    @Provides
    fun provideRepository(apiManager: ApiManager) : CategoryRepository =
        CategoryRepositoryImpl(apiManager)

    @Provides
    fun provideService(categoryRepository: CategoryRepository) : CategoryService =
        CategoryService(categoryRepository)

}
