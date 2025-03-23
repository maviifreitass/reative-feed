package org.feed.repository

import org.feed.entity.FeedMessage
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

@Repository
interface FeedRepository : ReactiveMongoRepository<FeedMessage, String> {
}