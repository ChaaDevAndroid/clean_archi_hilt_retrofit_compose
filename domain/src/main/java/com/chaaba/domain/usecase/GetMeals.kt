package com.chaaba.domain.usecase

import com.chaaba.domain.repo.IMealRepo

class GetMeals(private val _repo: IMealRepo) {
    suspend operator fun invoke() = _repo.getMealsFromRemote()
}