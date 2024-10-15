package com.example.displaydatafromserver.data.api

import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import retrofit2.http.GET

interface JSONPlaceholderAPI {
    @GET("/posts")
    suspend fun allPosts(): JSONPlaceHolderResponse
}