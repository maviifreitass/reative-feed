package org.feed.service

import org.feed.entity.FeedMessage
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import org.feed.repository.FeedRepository

@Service
class FeedService(private val feedRepository: FeedRepository) {

    fun getFeed(): Flux<FeedMessage> = feedRepository.findAll()

    fun postFeed(content: String): Mono<FeedMessage> {
        val newMessage = FeedMessage(content = content)
        return feedRepository.save(newMessage)
    }

    fun updateFeed(id: String, updatedContent: String): Mono<FeedMessage> {
        return feedRepository.findById(id)
            .flatMap { existingMessage ->
                val updatedMessage = existingMessage.copy(content = updatedContent)
                feedRepository.save(updatedMessage)
            }
    }
}