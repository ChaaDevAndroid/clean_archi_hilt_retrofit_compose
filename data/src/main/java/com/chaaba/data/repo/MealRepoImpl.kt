package com.chaaba.data.repo

import com.chaaba.data.local.IMealDao
import com.chaaba.data.remote.IApiServiceMeals
import com.chaaba.domain.pojo.CategoryResponse
import com.chaaba.domain.repo.IMealRepo

class MealRepoImpl(private val apiServiceMeals: IApiServiceMeals, private val mealsDao: IMealDao) :
    IMealRepo {

    //remote data
    override suspend fun getMealsFromRemote(): CategoryResponse = apiServiceMeals.getMeals()

    //local data
    override suspend fun getMealsFromLocal(): CategoryResponse =
        CategoryResponse(categories = mealsDao.getCategories())

    //Single Source Of Truth (SST)
    override suspend fun getMeals(): CategoryResponse {
        val localMeals = getMealsFromLocal()
        return if (localMeals.categories.isEmpty()) {
            val remoteMeals = getMealsFromRemote()
            val categories = remoteMeals.categories
            mealsDao.insertMeals(categories)
            remoteMeals
        } else {
            localMeals
        }
    }


}