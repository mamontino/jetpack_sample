package com.andro.domain

import com.andro.domain.dto.login.LoginRequest
import com.andro.domain.dto.login.LoginResponse
import com.andro.domain.dto.recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun requestRecipes(): Flow<Resource<Recipes>>
    suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
    suspend fun addToFavourite(id: String): Flow<Resource<Boolean>>
    suspend fun removeFromFavourite(id: String): Flow<Resource<Boolean>>
    suspend fun isFavourite(id: String): Flow<Resource<Boolean>>
}
