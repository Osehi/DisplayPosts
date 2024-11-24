package com.example.displaydatafromserver.data.repository

import com.example.displaydatafromserver.di.NetworkService
import com.example.displaydatafromserver.domain.repository.JSONRepository
import com.example.displaydatafromserver.domain.utils.Resource
import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import com.example.displaydatafromserver.model.JSONPlaceHolderResponseItem

class JSONPlaceholderRepositoryImpl: JSONRepository {
    override suspend fun getAllPost(): Resource<List<JSONPlaceHolderResponseItem>> {
        return try {
            Resource.Success(
                data = NetworkService.remoteService().allPosts()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

}