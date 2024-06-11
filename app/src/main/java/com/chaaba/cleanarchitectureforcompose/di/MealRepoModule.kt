package com.chaaba.cleanarchitectureforcompose.di

import com.chaaba.data.local.IMealDao
import com.chaaba.data.remote.IApiServiceMeals
import com.chaaba.data.repo.MealRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MealRepoModule {

    @Provides
    @Singleton
    fun provideRepo(apiServiceMeals: IApiServiceMeals, mealsDao: IMealDao) =
        MealRepoImpl(apiServiceMeals, mealsDao)

}