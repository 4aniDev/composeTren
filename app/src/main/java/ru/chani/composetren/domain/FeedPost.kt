package ru.chani.composetren.domain

import ru.chani.composetren.R

data class FeedPost(
    val communityName: String = "4aniGroup",
    val publicationDate: String = "11:01",
    val avatarResID: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "OSI model is a conceptual model that \\'provides a common basis for the coordination of [ISO] standards development for the purpose of systems interconnection\\'",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 545),
        StatisticItem(type = StatisticType.SHARES, count = 7),
        StatisticItem(type = StatisticType.COMMENTS, count = 8),
        StatisticItem(type = StatisticType.LIKES, count = 23),
    )
)
