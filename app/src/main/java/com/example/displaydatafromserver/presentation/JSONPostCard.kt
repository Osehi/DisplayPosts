package com.example.displaydatafromserver.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JSONPostCard(
    state: JSONPlaceholderState,
    colors: CardColors,
    modifier: Modifier = Modifier
) {
    state.jsonPlaceholderResponse?.let { item ->
        item.map { singleItem ->
            Card(
                colors = colors,
                shape = RoundedCornerShape(12.dp),
                modifier = modifier.padding(16.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = singleItem.title,
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        color = Color.White,
                        maxLines = 1
                    )
                    Spacer(
                        modifier = modifier
                            .height(2.dp)
                    )
                    Text(
                        text = singleItem.body
                    )

                }

            }
        }
    }

}




@Preview(showBackground = true)
@Composable
fun SeePreview() {
//    JSONPostCard(state = null, colors = )
}