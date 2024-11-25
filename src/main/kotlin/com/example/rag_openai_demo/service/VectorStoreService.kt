package com.example.rag_openai_demo.service

import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.SearchRequest
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
        //TODO Create test data here
        private val recipeDocuments = listOf(
            Document("My favorite recipe is cinema rolls. This is a middle healthy one."),
            Document("My favorite recipe is cinema rolls with chocolate. This is not healthy at all."),
            Document("My favorite recipe is carrot cake with chocolate. This is the healthiest option.")
        )
    }

}