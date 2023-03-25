package ru.chani.composetren.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun InstaProfileCard() {

    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .width(500.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .size(80.dp)
                    .background(Color.Cyan)
            ) {

            }
            TwoBoxes(firstLine = "6,900", secondLine = "Post")
            TwoBoxes(firstLine = "76", secondLine = "Followers")
            TwoBoxes(firstLine = "756", secondLine = "Following")
        }
    }
}


@Composable
private fun TwoBoxes(firstLine: String, secondLine: String) {
    Column(
        modifier = Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box {
            Text(text = firstLine)
        }
        Box {
            Text(text = secondLine)
        }
    }
}
