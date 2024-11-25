package com.example.rag_openai_demo.api

import com.example.rag_openai_demo.service.VectorStoreService
import org.springframework.ai.azure.openai.AzureOpenAiChatModel
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor
import org.springframework.ai.vectorstore.SearchRequest
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class RecipeController(
    private val vectorStoreService: VectorStoreService,
    private val vectorStore: VectorStore,
    private val chatModel: AzureOpenAiChatModel
) {
    @GetMapping("/recipe-recommendation")
    fun getRecipeEmbedding(@RequestParam prompt: String?): PromptResponse {
        // 1. Save all of our documents
        vectorStoreService.saveDocuments()

        val promptInput = prompt ?: "Give me a recipe recommendation"

        // 2. Configure the chat client to search into the Vector Store
        val chatClientCustom = ChatClient.builder(chatModel)
            .defaultAdvisors(
                QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults())
            ).build()

        // 3. Execute the Query against the LLM
        val response: String = chatClientCustom.prompt()
            .user(promptInput)
            .call()
            .content()

        return PromptResponse(
            originalPrompt = promptInput,
            searchResult = response
        )
    }
}