package com.example.rag_openai_demo.service

import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.SearchRequest
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class VectorStoreService(
    private val vectorStore: VectorStore
) {
    fun searchVectorStore(prompt: String): Document {
        // save
        vectorStore.add(recipeDocuments)
        //search
        val result = vectorStore.similaritySearch(
            SearchRequest
                .query(prompt)
                .withTopK(5)
        )
        return filterSearchResult(result)
    }

    private fun filterSearchResult(documents: List<Document>) =
        if (documents.isNotEmpty()) {
            documents.first()
        } else Document("Sorry, no good match found with your prompt. Please try again.")


    companion object {
        //TODO Create test data here
        private val recipeDocuments = listOf(
            Document("My favorite recipe is cinema rolls. This is a middle healthy one."),
            Document("My favorite recipe is cinema rolls with chocolate. This is not healthy at all."),
            Document("My favorite recipe is carrot cake with chocolate. This is the healthiest option.")
        )
    }

}