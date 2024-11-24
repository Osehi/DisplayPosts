package com.example.displaydatafromserver.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displaydatafromserver.data.repository.JSONPlaceholderRepositoryImpl
import com.example.displaydatafromserver.domain.repository.JSONRepository
import com.example.displaydatafromserver.domain.utils.Resource
import kotlinx.coroutines.launch

class JSONPlaceholderViewModel: ViewModel() {
    private val repository: JSONRepository = JSONPlaceholderRepositoryImpl()

    // what is the purpose of a ViewModel
    // viewModel coordinated all the data

    var state by mutableStateOf(JSONPlaceholderState())
        private set

    fun loadAllPosts() {
        viewModelScope.launch {
            // loading
            state = state.copy(
                isLoading = true,
                error = null
            )
            // when result is ready
            when(val result = repository.getAllPost()) {
                is Resource.Success -> {
                    state = state.copy(
                        jsonPlaceholderResponse = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        jsonPlaceholderResponse = null,
                        isLoading = false,
                        error = result.message
                    )
                }

            }
        }
    }


}