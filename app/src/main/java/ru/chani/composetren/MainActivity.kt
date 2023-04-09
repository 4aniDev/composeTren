package ru.chani.composetren

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import ru.chani.composetren.ui.theme.ComposeTrenTheme
import ru.chani.composetren.ui.theme.InstaProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            ComposeTrenTheme {
//                Box for background
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    Test(viewModel)
                }
            }
        }
    }
}


@Composable
fun Test(viewModel: MainViewModel) {
    LazyColumn() {

        item {
            Text(
                text = "Title",
                fontSize = 20.sp,
                color = MaterialTheme.colors.onSecondary
            )
        }
        items(10) {index ->
            InstaProfileCard(viewModel)
            Log.d("TAG_LAZY", index.toString())
        }
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_insta),
                contentDescription = null
            )
        }

        items(200) {
            InstaProfileCard(viewModel)
        }
    }

}