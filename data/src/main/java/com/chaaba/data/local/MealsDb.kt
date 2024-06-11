package com.chaaba.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chaaba.domain.pojo.Category

@Database(entities = [Category::class], version = 1, exportSchema = true)
abstract class MealsDb : RoomDatabase() {
    abstract fun getMealsDao(): IMealDao

}