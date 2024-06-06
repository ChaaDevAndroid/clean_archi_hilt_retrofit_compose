package com.chaaba.domain.repo

import com.chaaba.domain.pojo.CategoryResponse

interface IMealRepo {
    suspend fun getMealsFromRemote():CategoryResponse
}