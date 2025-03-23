package org.feed.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "feed")
data class FeedMessage(
    @Id val id: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val content: String,
    val likes: Int = 0,
    val comments: String
)
