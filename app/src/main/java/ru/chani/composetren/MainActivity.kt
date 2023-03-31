package ru.chani.composetren

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.chani.composetren.ui.theme.ComposeTrenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

@Composable
fun Test() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar Title")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            Text(
                text = "Zero Text"
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                shape = RectangleShape
            ) {
                Text(text = "First Page")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                shape = RectangleShape
            ) {
                Text(text = "Second Page")
            }

            IconButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }
            ) { Icon(Icons.Outlined.Clear, contentDescription = null)}


        },
        bottomBar = {
            BottomNavigation {
//                val items = listOf("First", "Second", "Third")
//
//                items.forEachIndexed { index, item ->
//                    BottomNavigationItem(
//                        icon = { Icon(Icons.Filled.Add, "") },
//                        label = { Text(item) },
//                        selected = index == 1,
//                        onClick = {}
//                    )
//                }

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, null) },
                    label = { Text("Favorite") },
                    selected = true,
                    onClick = {}
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Outlined.Add, null) },
                    label = { Text("Plus") },
                    selected = false,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Outlined.Settings, null) },
                    label = { Text("Settings") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is Scaffold content"
        )
    }
}