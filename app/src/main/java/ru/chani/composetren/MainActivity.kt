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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ExampleThird()
    }
}

@Composable
fun ExampleOne() {
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "Hello Ashgabat")
    }
}

@Composable
fun ExampleSecond() {
    TextField(value = "Value",
        onValueChange = {},
        label = { Text(text = "Label") })
}


@Composable
fun ExampleThird() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(text = "Are you sure?") },
        text = { Text(text = "Do you want to change your JOB?")},
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Yeah!")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "  No  ", textDecoration = TextDecoration.LineThrough)
            }
        },
        shape = RoundedCornerShape(15)
    )
}

