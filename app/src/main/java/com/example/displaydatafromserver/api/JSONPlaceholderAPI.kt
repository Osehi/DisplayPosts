package com.example.displaydatafromserver.api

import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import retrofit2.http.GET

interface JSONPlaceholderAPI {
    @GET("/posts")
    fun allPosts(): JSONPlaceHolderResponse
}