package com.example.displaydatafromserver.domain.repository

import com.example.displaydatafromserver.domain.utils.Resource
import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import com.example.displaydatafromserver.model.JSONPlaceHolderResponseItem

interface JSONRepository {
    suspend fun getAllPost(): Resource<List<JSONPlaceHolderResponseItem>>
}