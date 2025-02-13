package com.petros.efthymiou.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "2fbc6453f6d44725bb3b74970011bf3e"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response = httpClient.get("https://newsapi.org/v2/top-headlines") {
            parameter("country", country)
            parameter("category", category)
            parameter("apiKey", apiKey)
        }.body<ArticlesResponse>()
        return response.articles
    }
}
