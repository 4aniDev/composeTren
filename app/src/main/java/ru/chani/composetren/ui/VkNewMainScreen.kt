package ru.chani.composetren.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.chani.composetren.MainViewModel
import ru.chani.composetren.domain.FeedPost
import ru.chani.composetren.ui.theme.PostCard

private const val DEFAULT_INDEX_OF_SELECTED_ITEM = 0

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {

    val feedPost = viewModel.feedPost.observeAsState(FeedPost())

    Scaffold(
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
        PostCard(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            /**
             * при клике в нужном значении увеличиваю значение на еденицу
             *
             * сигнатуру функции указываю так сказать в рутовом элементе,
             * при этом тело этой функции получит параметр (clickedItem)
             * позже в стеке, когда данный параметр будет откуда брать
             *
             * Когда доработаю приложение, во вьюМодели будет под каждое дейтсвие своя функция
             *
             *
             * viewModel::update - эт у нас референс метод, запись равно значна:
             * { it ->
                    viewModel.updateCount(it)
                }
             * то есть в функию update у объекта viewModel про брасываем значени,
             * которое приходит в лямбду. В данном случае объект с типом StatisticItem.
             */

            onViewsItemListener = viewModel::updateCount,
            onSharesItemListener = viewModel::updateCount,
            onCommentsItemListener = { clickedItem ->
                viewModel.updateCount(clickedItem)
            },
            onLikesItemListener = { clickedItem ->
                viewModel.updateCount(clickedItem)
            },
        )
    }
}

