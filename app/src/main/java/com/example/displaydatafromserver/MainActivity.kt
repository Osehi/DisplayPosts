package com.example.displaydatafromserver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.displaydatafromserver.presentation.JSONPlaceholderViewModel
import com.example.displaydatafromserver.presentation.JSONPostCard
import com.example.displaydatafromserver.presentation.ListOfPost
import com.example.displaydatafromserver.presentation.theme.DisplayDataFromServerTheme

class MainActivity : ComponentActivity() {
    /**
     * Task: To Test UI and Network Call
     */

    private val viewModel: JSONPlaceholderViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadAllPosts()
        setContent {
            DisplayDataFromServerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")

                    ListOfPost(viewModel = viewModel)
                }
            }
        }
    }
}




// in search of a progress bar
@Composable
fun IndeterminateCircularProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(50.dp) // Customize the size
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DisplayDataFromServerTheme {
        Greeting("Android")
    }
}