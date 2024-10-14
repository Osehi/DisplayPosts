package com.example.displaydatafromserver.domain.repository

import com.example.displaydatafromserver.model.JSONPlaceHolderResponse

interface JSONRepository {
    suspend fun getAllPost(): JSONPlaceHolderResponse
}