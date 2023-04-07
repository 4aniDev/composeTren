package ru.chani.composetren.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.chani.composetren.R
import ru.chani.composetren.domain.FeedPost
import ru.chani.composetren.domain.StatisticItem
import ru.chani.composetren.domain.StatisticType


/**
 * onStatisticItemListener: (StatisticItem) -> Unit
 * здесь я только указываю что мне нужнеж параметр StaticItem,
 * но его предоствавить я не могу, по этому пробрасываю функцию  onStatisticItemListener
 * дальше, указывая ссылку на неё (onItemClickListener = onStatisticItemListener)
 * я это могу сделать так сигнатура одинаковая
 */

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewsItemListener: (StatisticItem) -> Unit,
    onSharesItemListener: (StatisticItem) -> Unit,
    onCommentsItemListener: (StatisticItem) -> Unit,
    onLikesItemListener: (StatisticItem) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            PostHeader(feedPost = feedPost)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = feedPost.contentText)
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = feedPost.contentImageResId),
                contentDescription = "image",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(5.dp))
            Statistics(
                statistics = feedPost.statistics,
//                сигнатура методов одинаковая, по этому просто присваиваю
                onViewsItemListener = onViewsItemListener,
                onSharesItemListener = onSharesItemListener,
                onCommentsItemListener = onCommentsItemListener,
                onLikesItemListener = onLikesItemListener
            )

        }
    }
}

@Composable
private fun PostHeader(feedPost: FeedPost) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = feedPost.avatarResID),
            contentDescription = "avatar"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = feedPost.communityName
            )
            Text(
                color = MaterialTheme.colors.onSecondary,
                text = feedPost.publicationDate
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "More",
            tint = MaterialTheme.colors.onSecondary
        )
    }
}


/**
 * крч здесь я уже могу предоставить StaticItem, по этому выполняю
 * функцию которую получил сначала из PostCard(), а если брать еще раньше то получил из
 * MainScreen() -> Scaffold() -> PostCard() {}
 * ну и в лямбде описал что делать то вообще
 */
@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
    onViewsItemListener: (StatisticItem) -> Unit,
    onSharesItemListener: (StatisticItem) -> Unit,
    onCommentsItemListener: (StatisticItem) -> Unit,
    onLikesItemListener: (StatisticItem) -> Unit
) {
    Row {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(
                iconResId = R.drawable.ic_views_count,
                text = viewsItem.count.toString(),
                onItemClickListener = {
                    onViewsItemListener(viewsItem)
                }
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithText(
                iconResId = R.drawable.ic_share,
                text = sharesItem.count.toString(),
                onItemClickListener = {
                    onSharesItemListener(sharesItem)
                }
            )

            val commentItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = commentItem.count.toString(),
                onItemClickListener = {
                    onCommentsItemListener(commentItem)
                }
            )

            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(
                iconResId = R.drawable.ic_like,
                text = likesItem.count.toString(),
                onItemClickListener = {
                    onLikesItemListener(likesItem)
                }
            )

        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException()
}

/**
 * здесь же тупо беру функцию которая пришла "сверху" и выполняю ее по нажатию
 */
@Composable
private fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener()
        },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = text,
            tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            color = MaterialTheme.colors.onSecondary,
            text = text
        )
    }
}