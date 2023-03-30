package ru.chani.composetren.ui.theme

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.chani.composetren.R


@Composable
fun PostCard() {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            PostHeader()
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = stringResource(R.string.template_text))
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = "image",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(5.dp))
            Statistics()

        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = "4aniGroup"
            )
            Text(
                color = MaterialTheme.colors.onSecondary,
                text = "11:40"
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "More",
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun Statistics() {
    Row {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconWithText(iconResId = R.drawable.ic_views_count, text = "916")
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconWithText(iconResId = R.drawable.ic_share, text = "7")
            IconWithText(iconResId = R.drawable.ic_comment, text = "8")
            IconWithText(iconResId = R.drawable.ic_like, text = "23")

        }
    }


}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String
) {
    Row(
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


@Preview
@Composable
private fun PreviewDarkTheme() {
    ComposeTrenTheme(darkTheme = true) {
        PostCard()
    }
}

@Preview
@Composable
private fun PreviewLightTheme() {
    ComposeTrenTheme(darkTheme = false) {
        PostCard()
    }
}