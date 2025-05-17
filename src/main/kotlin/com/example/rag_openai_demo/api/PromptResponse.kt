package com.example.rag_openai_demo.api

data class PromptResponse(
    val originalPrompt: String,
    val searchResult: String? = null
)