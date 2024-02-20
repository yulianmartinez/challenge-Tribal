package com.ymd.infrastructure.repository

import com.ymd.domain.repository.CategoryRepository
import com.ymd.infrastructure.manager.ApiManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class CategoryRepositoryImpl(private val apiManager: ApiManager): CategoryRepository {

    override suspend fun getAllCategory(): Flow<List<String>> =
        flow {
            emit(apiManager.getAllCategory())
        }.catch {
            throw Exception("Error consulting categories")
        }

}