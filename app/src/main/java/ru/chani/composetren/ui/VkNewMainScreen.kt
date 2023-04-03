package ru.chani.composetren.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

private const val DEFAULT_INDEX_OF_SELECTED_ITEM = 0

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember {
        mutableStateOf(true)
    }


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                message = "This is Snackbar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )

                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible.value = false
                            }
                        }
                    }
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }

        },
        bottomBar = {
            BottomNavigation {
                Log.d("TAG_TEST", "recomposition of BottomNavigation")

                val selectedItemIndex = remember {
                    mutableStateOf(DEFAULT_INDEX_OF_SELECTED_ITEM)
                }

                val listOfItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )

                listOfItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationItem(
                        selected = selectedItemIndex.value == index,
                        onClick = { selectedItemIndex.value = index },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = stringResource(id = navigationItem.titleResId)
                            )
                        },
                        label = { Text(text = stringResource(id = navigationItem.titleResId)) },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }

    ) {

    }
}

