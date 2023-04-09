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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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

    val models = viewModel.models.observeAsState(listOf())

    LazyHorizontalGrid(rows = GridCells.Adaptive(200.dp)) {
        items(models.value) { model ->
            InstaProfileCard(
                model = model,
                onFollowedButtonClickListener = { viewModel.changeFollowingStatus(model) }
            )
        }
    }

}