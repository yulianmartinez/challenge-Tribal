package com.ymd.infrastructure.manager

import retrofit2.http.GET

interface CategoryEndpoint {

    @GET("categories")
    suspend fun getAllCategory() : List<String>

}