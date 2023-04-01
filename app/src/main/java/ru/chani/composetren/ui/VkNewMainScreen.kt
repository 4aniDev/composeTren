package ru.chani.composetren.ui

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource

private const val DEFAULT_INDEX_OF_SELECTED_ITEM = 0

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigation {

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

