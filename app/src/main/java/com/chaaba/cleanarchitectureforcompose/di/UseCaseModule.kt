package com.chaaba.cleanarchitectureforcompose.di

import com.chaaba.data.repo.MealRepoImpl
import com.chaaba.domain.usecase.GetMealUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMeals(repoImpl: MealRepoImpl) = GetMealUseCase(repoImpl)

}