package com.example.rag_openai_demo.service

import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class VectorStoreService(
    private val vectorStore: VectorStore
) {
    /**
     * Creates embeddings and saves them into the vector store
     */
    fun saveDocuments() = vectorStore.add(recipeDocuments)

    companion object {
        private val recipeDocuments = listOf(
            Document("Dessert option - vegan carrot cake with dark chocolate. This is the healthiest option."),
            Document("Dessert option - cardamom cinnamon rolls based on traditional recipe. This is middle healthy."),
            Document("Dessert option - low sugar vanilla ice cream with strawberries. This is also a healthy option due to its low sugar content.")
        )
    }

}