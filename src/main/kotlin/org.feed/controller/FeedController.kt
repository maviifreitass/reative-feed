package org.feed.controller

import org.feed.dto.FeedMessageDto
import org.feed.entity.FeedMessage
import org.feed.service.FeedService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/feed")
class FeedController(private val feedService: FeedService) {

    @GetMapping
    fun getFeed(): Flux<FeedMessage> = feedService.getFeed()

    @PostMapping
    fun postFeed(@RequestBody request: Map<String, String>): Mono<FeedMessage> {
        val content = request["content"] ?: throw IllegalArgumentException("Content is required")
        return feedService.postFeed(content)
    }

    @PutMapping("/{id}")
    fun updateFeed(@PathVariable id: String, @RequestBody request: Map<String, String>): Mono<FeedMessage> {
        val updatedContent = request["content"] ?: throw IllegalArgumentException("Content is required")
        return feedService.updateFeed(id, updatedContent)
    }
}