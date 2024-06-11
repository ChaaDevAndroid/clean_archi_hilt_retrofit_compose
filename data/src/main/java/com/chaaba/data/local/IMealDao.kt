package com.chaaba.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaaba.domain.pojo.Category
import com.chaaba.domain.pojo.CategoryResponse

@Dao
interface IMealDao {
    @Query("SELECT * FROM meals_table")
    suspend fun getCategories(): List<Category>

    @Insert
    suspend fun insertMeals(categories: List<Category>)

}