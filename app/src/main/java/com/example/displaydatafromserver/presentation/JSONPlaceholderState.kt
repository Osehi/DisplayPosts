package com.example.displaydatafromserver.presentation

import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import com.example.displaydatafromserver.model.JSONPlaceHolderResponseItem

data class JSONPlaceholderState(
    val jsonPlaceholderResponse: List<JSONPlaceHolderResponseItem>? = null,
    val isLoading: Boolean? = false,
    val error: String? = null
)