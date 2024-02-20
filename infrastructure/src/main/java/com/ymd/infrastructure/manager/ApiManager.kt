package com.ymd.infrastructure.manager

import javax.inject.Inject

class ApiManager @Inject constructor(private val categoryEndpoint: CategoryEndpoint) {

    suspend fun getAllCategory() : List<String> =
        categoryEndpoint.getAllCategory()

}