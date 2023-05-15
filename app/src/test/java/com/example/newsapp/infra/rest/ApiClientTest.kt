package com.example.newsapp.infra.rest

import com.example.newsapp.infra.models.ResponseStatus
import com.example.newsapp.infra.rest.ApiClient.API_KEY
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.Locale

class ApiClientTest {
    @Test
    fun `can get top headlines`() = runBlocking {
        val responseBody = ApiClient.apiService.getTopHeadlines(
            country = Locale.getDefault().language,
            apiKey = API_KEY
        ).body()

        assertNotNull(responseBody)
        assertEquals(ResponseStatus.OK, responseBody!!.status)
        assertTrue(responseBody.articles.isNotEmpty())
    }
}