package ru.chani.composetren.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstaProfileCard() {

    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
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
            UserStatistics(title = "Post", value = "6,900")
            UserStatistics(title = "Followers", value = "762M")
            UserStatistics(title = "Following", value = "756")
        }
    }
}


@Composable
private fun UserStatistics(title: String, value: String) {
    Column(
        modifier = Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
            Text(text = value, fontFamily = FontFamily.Cursive, fontSize = 25.sp)
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 12.sp,)
    }
}


@Preview
@Composable
private fun previewCardLight() {
    ComposeTrenTheme(darkTheme = false) {
        InstaProfileCard()
    }
}

@Preview
@Composable
private fun previewCardDark() {
    ComposeTrenTheme(darkTheme = true) {
        InstaProfileCard()
    }
}