package com.andro.data.remote

import com.andro.domain.Resource
import com.andro.domain.dto.recipes.Recipes
import com.andro.domain.dto.recipes.RecipesItem
import com.andro.domain.error.NETWORK_ERROR
import com.andro.domain.error.NO_INTERNET_CONNECTION
import com.andro.data.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val recipesService: RecipesService,
    private val networkConnectivity: NetworkConnectivity
) {

    suspend fun requestRecipes(): Resource<Recipes> {
        return when (val response = processCall(recipesService::fetchRecipes)) {
            is List<*> -> {
                Resource.Success(data = Recipes(response as ArrayList<RecipesItem>))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
