package com.example.displaydatafromserver.presentation

import androidx.lifecycle.ViewModel
import com.example.displaydatafromserver.data.repository.JSONPlaceholderRepositoryImpl
import com.example.displaydatafromserver.domain.repository.JSONRepository

class JSONPlaceholderViewModel: ViewModel() {
    private val repository: JSONRepository = JSONPlaceholderRepositoryImpl()


}