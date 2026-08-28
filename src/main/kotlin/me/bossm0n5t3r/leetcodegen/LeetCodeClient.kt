package me.bossm0n5t3r.leetcodegen

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

object LeetCodeClient {
    private val client = HttpClient(CIO) { install(ContentNegotiation) { json() } }
    private const val DOMAIN = "https://leetcode.com"
    private const val GRAPHQL_URL = "$DOMAIN/graphql"
    private const val PROBLEM_URL = "$DOMAIN/problems"
    private const val LANG_KOTLIN = "Kotlin"

    @Suppress("ktlint:standard:max-line-length")
    private const val GET_DAILY_LEET_CODE_PROBLEM_QUERY =
        "query GetDailyLeetCodeProblem { activeDailyCodingChallengeQuestion { link question { questionFrontendId title exampleTestcases codeSnippets { lang code } } } }"

    @Suppress("ktlint:standard:max-line-length")
    private const val GET_LEET_CODE_PROBLEM_BY_TITLE_SLUG_QUERY =
        $$"query GetLeetCodeProblemByTitleSlug($titleSlug: String!) { question(titleSlug: $titleSlug) { questionFrontendId title exampleTestcases codeSnippets { lang code } } }"

    @Suppress("ktlint:standard:max-line-length")
    private const val GET_LEET_CODE_CONTEST_PROBLEMS_BY_CONTEST_SLUG_QUERY =
        $$"query contestQuestionList($contestSlug: String!) { contestQuestionList(contestSlug: $contestSlug) { titleSlug } }"

    @Serializable data class GraphQLResponse<T>(val data: T)

    @Serializable
    data class QuestionWrapper(
        val question: DailyLeetCodeProblem.ActiveDailyCodingChallengeQuestion.Question
    )

    @Serializable
    data class DailyLeetCodeProblem(
        val activeDailyCodingChallengeQuestion: ActiveDailyCodingChallengeQuestion
    ) {
        @Serializable
        data class ActiveDailyCodingChallengeQuestion(val link: String, val question: Question) {
            @Serializable
            data class Question(
                val questionFrontendId: String,
                val title: String,
                val exampleTestcases: String,
                val codeSnippets: List<CodeSnippet>,
            ) {
                @Serializable data class CodeSnippet(val lang: String, val code: String)
            }
        }
    }

    @Serializable
    private data class ContestQuestionList(val contestQuestionList: List<ContestQuestion>) {
        @Serializable data class ContestQuestion(val titleSlug: String)
    }

    private fun List<DailyLeetCodeProblem.ActiveDailyCodingChallengeQuestion.Question.CodeSnippet>
        .toSampleCodes(): List<String> =
        this.find { it.lang == LANG_KOTLIN }?.code?.split("\n")
            ?: throw Exception("No Kotlin code snippet found")

    internal fun String.toInlineExampleTestcases(): String = trim().lines().joinToString(" / ")

    private fun String.toMethodParametersAndResultAsString(): String =
        this.substringAfter('(')
            .substringBefore('{')
            .split(", ", "): ")
            .let {
                val lastIndex = it.lastIndex
                it.mapIndexed { index, s ->
                    if (index != lastIndex) {
                        "val ${s.trim()}"
                    } else {
                        "val result: ${s.trim()}"
                    }
                }
            }
            .joinToString(", ")

    private fun DailyLeetCodeProblem.toLeetCodeProblem(): LeetCodeProblem {
        val sampleCodes: List<String> =
            this.activeDailyCodingChallengeQuestion.question.codeSnippets.toSampleCodes()
        return LeetCodeProblem(
            name =
                "${this.activeDailyCodingChallengeQuestion.question.questionFrontendId.trim()}. " +
                    this.activeDailyCodingChallengeQuestion.question.title.trim(),
            url = "$DOMAIN${this.activeDailyCodingChallengeQuestion.link.trim()}",
            sampleCodes = sampleCodes,
            methodParametersAndResultAsString =
                sampleCodes[1].toMethodParametersAndResultAsString(),
            exampleTestcases =
                this.activeDailyCodingChallengeQuestion.question.exampleTestcases
                    .toInlineExampleTestcases(),
        )
    }

    private fun DailyLeetCodeProblem.ActiveDailyCodingChallengeQuestion.Question.toLeetCodeProblem(
        titleSlug: String
    ): LeetCodeProblem {
        val sampleCodes: List<String> = this.codeSnippets.toSampleCodes()
        return LeetCodeProblem(
            name = "${this.questionFrontendId}. $title",
            url = "$PROBLEM_URL/$titleSlug/",
            sampleCodes = sampleCodes,
            methodParametersAndResultAsString =
                sampleCodes[1].toMethodParametersAndResultAsString(),
            exampleTestcases = this.exampleTestcases.toInlineExampleTestcases(),
        )
    }

    suspend fun getDailyLeetCodeProblem(): LeetCodeProblem {
        val response =
            client
                .post {
                    url(GRAPHQL_URL)
                    contentType(ContentType.Application.Json)
                    setBody(mapOf("query" to GET_DAILY_LEET_CODE_PROBLEM_QUERY))
                }
                .bodyAsText()
        return Json.decodeFromString<GraphQLResponse<DailyLeetCodeProblem>>(response)
            .data
            .toLeetCodeProblem()
    }

    suspend fun getLeetCodeProblemByTitleSlug(titleSlug: String): LeetCodeProblem {
        val response =
            client
                .post {
                    url(GRAPHQL_URL)
                    contentType(ContentType.Application.Json)
                    setBody(
                        mapOf(
                            "query" to GET_LEET_CODE_PROBLEM_BY_TITLE_SLUG_QUERY,
                            "variables" to Json.encodeToString(mapOf("titleSlug" to titleSlug)),
                        )
                    )
                }
                .bodyAsText()
        return Json.decodeFromString<GraphQLResponse<QuestionWrapper>>(response)
            .data
            .question
            .toLeetCodeProblem(titleSlug)
    }

    suspend fun getLeetCodeContestProblemTitleSlugsByContestSlug(
        contestSlug: String
    ): List<String> {
        val response =
            client
                .post {
                    url(GRAPHQL_URL)
                    contentType(ContentType.Application.Json)
                    setBody(
                        mapOf(
                            "query" to GET_LEET_CODE_CONTEST_PROBLEMS_BY_CONTEST_SLUG_QUERY,
                            "variables" to Json.encodeToString(mapOf("contestSlug" to contestSlug)),
                        )
                    )
                }
                .bodyAsText()
        return Json.decodeFromString<GraphQLResponse<ContestQuestionList>>(response)
            .data
            .contestQuestionList
            .map { it.titleSlug }
    }
}
