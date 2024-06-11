package com.chaaba.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals_table")
data class Category(
    @PrimaryKey val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)