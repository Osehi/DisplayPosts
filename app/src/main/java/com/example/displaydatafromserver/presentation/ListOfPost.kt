package com.example.displaydatafromserver.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ListOfPost(viewModel: JSONPlaceholderViewModel) {
    LazyColumn {
        item {

            JSONPostCard(
                state = viewModel.state,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue
                )
            )
        }
    }
}
