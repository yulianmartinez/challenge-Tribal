package com.ymd.challengetribal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymd.domain.services.CategoryService
import com.ymd.infrastructure.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryService: CategoryService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    private val _categoryList : MutableStateFlow<List<String>?> = MutableStateFlow(null)
    val categoryList: StateFlow<List<String>?> get() = _categoryList

    fun getAllCategory() =
        viewModelScope.launch(ioDispatcher) {
            try {
                categoryService.getAllCategory().collectLatest { categoryList ->
                    _categoryList.value = categoryList
                }
            } catch (exception: Exception) {
                _categoryList.value = null
            }
        }

}