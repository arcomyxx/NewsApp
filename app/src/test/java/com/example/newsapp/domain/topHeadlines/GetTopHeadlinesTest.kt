package com.example.newsapp.domain.topHeadlines

import com.example.newsapp.builders.buildArticle
import com.example.newsapp.domain.topHeadlins.GetTopHeadlines
import com.example.newsapp.domain.topHeadlins.TopHeadLinesPort
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GetTopHeadlinesTest {
    private val adapter = mockk<TopHeadLinesPort>()
    private val getTopHeadlines = GetTopHeadlines(adapter = adapter)

    @Test
    fun `returns success if receive articles`() {
        val expectedArticles = listOf(
            buildArticle(title = "title 1"),
            buildArticle(title = "title 2"),
        )

        coEvery { adapter.getTopHeadlines(any()) } returns expectedArticles

        val resource = getTopHeadlines()

        assertEquals(expectedArticles, resource.data)
    }

    @Test
    fun `returns error if throws error`() {
        val error = "error"

        coEvery { adapter.getTopHeadlines(any()) } throws Exception(error)

        val resource = getTopHeadlines()

        assertEquals(error, resource.message)
    }
}