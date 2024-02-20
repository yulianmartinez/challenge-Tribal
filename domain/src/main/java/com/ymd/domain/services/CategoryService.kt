package com.ymd.domain.services

import com.ymd.domain.repository.CategoryRepository

class CategoryService(private val categoryRepository: CategoryRepository) {

    suspend fun getAllCategory() =
        categoryRepository.getAllCategory()

}