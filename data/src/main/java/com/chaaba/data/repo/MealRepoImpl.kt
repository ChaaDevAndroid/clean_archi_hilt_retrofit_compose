package com.chaaba.data.repo

import com.chaaba.data.remote.IApiServiceMeals
import com.chaaba.domain.pojo.CategoryResponse
import com.chaaba.domain.repo.IMealRepo

class MealRepoImpl(private val apiServiceMeals: IApiServiceMeals) : IMealRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiServiceMeals.getMeals()
}