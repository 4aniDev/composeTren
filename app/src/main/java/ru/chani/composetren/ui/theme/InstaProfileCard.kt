package ru.chani.composetren.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.chani.composetren.MainViewModel
import ru.chani.composetren.R

@Composable
fun InstaProfileCard(
    viewModel: MainViewModel
) {
    /**
     * This function converts our LiveData object to State object.
     * if we set initial state to function
     * variable will be NON_NULLABLE, for example (State<Boolean>)
     * else
     * variable will be NULLABLE (State<Boolean?>)
     * */
    val isFollowed: State<Boolean> =  viewModel.isFollowing.observeAsState(false)

    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(500.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_insta),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                )
                UserStatistics(title = "Post", value = "6,900")
                UserStatistics(title = "Followers", value = "762M")
                UserStatistics(title = "Following", value = "756")
            }
            Text(
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                text = "Instagram"
            )
            Text(text = "#YoursToMake")
            Text(text = "www.facebook.com/emotional_health")

            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowingSate()
            }
        }

    }
}


    /**
     * Лучше пробрасывать состояния непосредственно в ту функию, где это состояние будет
     * использоаться.
     * В данном случае isFollowed должна быть не просто Boolean, а State<Boolean>.
     * Это нужно чтобы вызывающие функции не зависили от ее состояния, а следовательно
     * и не происходила рекомпозиция в вышестоящих в стеке функциях.
     *
     * Выше, можно было бы написать вот так:
     * FollowButton(isFollowed = isFollowed.value) {
        viewModel.changeFollowingSate()
        }
     * Тогда, функция Card() зависила бы от этого стейта, и каждый раз при изменении состояния
     * кнопки, прихоилось бы перерисовывать и Card()
     */
@Composable
private fun FollowButton(
    isFollowed: State<Boolean>,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isFollowed.value) {
                MaterialTheme.colors.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colors.primary
            }
        )
    ) {
        val text = if (isFollowed.value) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text = text)
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
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 12.sp)
    }
}