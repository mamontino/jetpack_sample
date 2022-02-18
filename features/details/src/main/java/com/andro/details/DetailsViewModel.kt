package com.andro.details

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andro.domain.DataRepository
import com.andro.domain.Resource
import com.andro.domain.dto.recipes.RecipesItem
import com.andro.domain.error.ErrorHandler
import com.andro.ui_common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class DetailsViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val errorHandler: ErrorHandler
) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val recipePrivate = MutableLiveData<RecipesItem>()
    val recipeData: LiveData<RecipesItem> get() = recipePrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val isFavouritePrivate = MutableLiveData<Resource<Boolean>>()
    val isFavourite: LiveData<Resource<Boolean>> get() = isFavouritePrivate

    fun initIntentData(recipe: RecipesItem) {
        recipePrivate.value = recipe
    }

    open fun addToFavourites() {
        viewModelScope.launch {
            isFavouritePrivate.value = Resource.Loading()
            recipePrivate.value?.id?.let {
                dataRepository.addToFavourite(it).collect { isAdded ->
                    isFavouritePrivate.value = isAdded
                }
            }
        }
    }

    fun removeFromFavourites() {
        viewModelScope.launch {
            isFavouritePrivate.value = Resource.Loading()
            recipePrivate.value?.id?.let {
                dataRepository.removeFromFavourite(it).collect { isRemoved ->
                    when (isRemoved) {
                        is Resource.Success -> {
                            isRemoved.data?.let { isFavouritePrivate.value = Resource.Success(!isRemoved.data!!) }
                        }
                        is Resource.DataError -> {
                            isFavouritePrivate.value = isRemoved
                        }
                        is Resource.Loading -> {
                            isFavouritePrivate.value = isRemoved
                        }
                    }
                }
            }
        }
    }

    fun isFavourites() {
        viewModelScope.launch {
            isFavouritePrivate.value = Resource.Loading()
            recipePrivate.value?.id?.let {
                dataRepository.isFavourite(it).collect { isFavourites ->
                    isFavouritePrivate.value = isFavourites
                }
            }
        }
    }
}
