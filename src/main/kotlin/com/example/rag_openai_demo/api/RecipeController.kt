package com.example.rag_openai_demo.api

import com.example.rag_openai_demo.service.VectorStoreService
import org.springframework.ai.embedding.EmbeddingModel
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipeController(
    private val vectorStoreService: VectorStoreService
) {
    @GetMapping("/recipe-recommendation")
    fun getRecipeEmbedding(@RequestParam prompt: String?): PromptResponse {
        val promptInput = prompt ?: "Give me a recipe recommendation"
        //TODO Delete only for test purposes
        val document = vectorStoreService.searchVectorStore(promptInput)
        return PromptResponse(
            originalPrompt = promptInput,
            searchResult = document.content
        )
    }
}