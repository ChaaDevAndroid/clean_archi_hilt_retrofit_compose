package com.chaaba.cleanarchitectureforcompose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chaaba.domain.pojo.CategoryResponse
import com.chaaba.domain.usecase.GetMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MealViewModel"

@HiltViewModel
class MealViewModel @Inject constructor(private val _useCase: GetMealUseCase) : ViewModel() {

    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoryResponse?> = _categories

    fun getMeals(): Job = viewModelScope.launch {
        try {
            _categories.value = _useCase()
        } catch (e: Exception) {
            Log.e(TAG, "getMeals: ${e.message}")
        }
    }

}