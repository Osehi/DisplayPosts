package com.example.displaydatafromserver.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displaydatafromserver.MainActivity
import com.example.displaydatafromserver.data.repository.JSONPlaceholderRepositoryImpl
import com.example.displaydatafromserver.domain.repository.JSONRepository
import com.example.displaydatafromserver.domain.utils.Resource
import com.example.displaydatafromserver.model.JSONPlaceHolderResponse
import com.example.displaydatafromserver.model.JSONPlaceHolderResponseItem
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class FakePostRepository: JSONRepository {
    override suspend fun getAllPost(): Resource<List<JSONPlaceHolderResponseItem>> {
        val mockedData = listOf<JSONPlaceHolderResponseItem>(
            JSONPlaceHolderResponseItem("osehi", 1, "Lag",1),
            JSONPlaceHolderResponseItem("Kemi", 2, "Cal",2),
            JSONPlaceHolderResponseItem("Ayo", 3, "Abj",3)
        )
      return Resource.Success(mockedData)
    }

}
class MyPostViewModel: ViewModel() {

    private val repository: JSONRepository = FakePostRepository()

    private val _posts = MutableLiveData<Resource<List<JSONPlaceHolderResponseItem>>>()
    val posts: LiveData<Resource<List<JSONPlaceHolderResponseItem>>> = _posts

    init {
        viewModelScope.launch {
            try {
                val data = repository.getAllPost()
                _posts.postValue(data)
            } catch (e: Exception) {

            }
        }
    }


}
class ListOfPostKtTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()


    @Test
    fun displayMyPost() {
        val testViewModel = MyPostViewModel()

        rule.setContent {
//            ListOfPost(viewModel = testViewModel)
        }

        rule.waitForIdle() // simulate the loading process

        rule.onNodeWithText("osehi").assertIsDisplayed()

    }


}