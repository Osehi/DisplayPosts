package com.example.displaydatafromserver.di

import com.example.displaydatafromserver.data.api.JSONPlaceholderAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    // create a retrofit instance
    private val BASEURL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // a function to return the service
    fun remoteService(): JSONPlaceholderAPI {
        return retrofit.create(JSONPlaceholderAPI::class.java)
    }
}