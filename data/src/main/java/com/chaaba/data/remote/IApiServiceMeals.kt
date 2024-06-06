package com.chaaba.data.remote

import com.chaaba.domain.pojo.CategoryResponse
import retrofit2.http.GET

interface IApiServiceMeals {
    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}