package org.feed.dto


data class FeedMessageDto(
    val id: String,
    val timestamp: Long,
    val content: String,
    val likes: Int
)
