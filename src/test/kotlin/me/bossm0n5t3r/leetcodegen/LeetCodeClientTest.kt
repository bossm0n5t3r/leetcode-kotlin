package me.bossm0n5t3r.leetcodegen

import kotlinx.serialization.json.Json
import me.bossm0n5t3r.leetcodegen.LeetCodeClient.toInlineExampleTestcases
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LeetCodeClientTest {
    @Test
    fun deserializationTest() {
        val responseString =
            """
            {
              "data": {
                "activeDailyCodingChallengeQuestion": {
                  "link": "/problems/count-the-number-of-complete-components/",
                  "question": {
                    "questionFrontendId": "2685",
                    "title": "Count the Number of Complete Components",
                    "exampleTestcases": "6\n[[0,1],[0,2],[1,2],[3,4]]\n6\n[[0,1],[0,2],[1,2],[3,4],[3,5]]",
                    "codeSnippets": [
                      {
                        "lang": "Kotlin",
                        "code": "class Solution {\n    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {\n        \n    }\n}"
                      }
                    ]
                  }
                }
              }
            }
            """
                .trimIndent()

        assertDoesNotThrow {
            Json.decodeFromString<
                LeetCodeClient.GraphQLResponse<LeetCodeClient.DailyLeetCodeProblem>
            >(
                responseString
            )
        }
    }

    @Test
    fun serializationTest() {
        val result =
            Json.encodeToString(
                mapOf(
                    "query" to "dummy query",
                    "variables" to Json.encodeToString(mapOf("titleSlug" to "dummy-title-slug")),
                )
            )
        assertEquals(
            "{\"query\":\"dummy query\",\"variables\":\"{\\\"titleSlug\\\":\\\"dummy-title-slug\\\"}\"}",
            result,
        )
    }

    @Test
    fun `toInlineExampleTestcases normalizes LF-only input to a single inline string`() {
        val input = "4\n[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]\n1\n4"

        val result = input.toInlineExampleTestcases()

        assertEquals("4 / [[1,2,9],[2,3,6],[2,4,5],[1,4,7]] / 1 / 4", result)
        assertFalse(result.contains("\n"), "normalized string must not contain \\n")
        assertFalse(result.contains("\r"), "normalized string must not contain \\r")
    }

    @Test
    fun `toInlineExampleTestcases normalizes CRLF and trailing CR input to a single inline string`() {
        val input = "\"acbac\"\r\n[1,2,3,0]\r"

        val result = input.toInlineExampleTestcases()

        assertEquals("\"acbac\" / [1,2,3,0]", result)
        assertFalse(result.contains("\n"), "normalized string must not contain \\n")
        assertFalse(result.contains("\r"), "normalized string must not contain \\r")
    }
}
