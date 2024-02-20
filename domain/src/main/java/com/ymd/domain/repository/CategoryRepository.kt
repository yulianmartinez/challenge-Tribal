package com.ymd.domain.repository

import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getAllCategory() : Flow<List<String>>
}