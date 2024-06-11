package com.chaaba.cleanarchitectureforcompose.di

import android.app.Application
import androidx.room.Room
import com.chaaba.data.local.IMealDao
import com.chaaba.data.local.MealsDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideLocalDb(application: Application): MealsDb = Room.databaseBuilder(
        application, MealsDb::class.java, "meals_db"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    fun provideDao(mealsDb: MealsDb): IMealDao = mealsDb.getMealsDao()
}