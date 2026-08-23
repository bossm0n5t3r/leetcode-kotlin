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
        @Suppress("ktlint:standard:max-line-length")
        val responseString =
            "{\"data\":{\"activeDailyCodingChallengeQuestion\":{\"link\":\"/problems/count-the-number-of-complete-components/\",\"question\":{\"questionFrontendId\":\"2685\",\"title\":\"Count the Number of Complete Components\",\"content\":\"<p>You are given an integer <code>n</code>. There is an <strong>undirected</strong> graph with <code>n</code> vertices, numbered from <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists an <strong>undirected</strong> edge connecting vertices <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>\\n\\n<p>Return <em>the number of <strong>complete connected components</strong> of the graph</em>.</p>\\n\\n<p>A <strong>connected component</strong> is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.</p>\\n\\n<p>A connected component is said to be <b>complete</b> if there exists an edge between every pair of its vertices.</p>\\n\\n<p>&nbsp;</p>\\n<p><strong class=\\\"example\\\">Example 1:</strong></p>\\n\\n<p><strong class=\\\"example\\\"><img alt=\\\"\\\" src=\\\"https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-31-23.png\\\" style=\\\"width: 671px; height: 270px;\\\" /></strong></p>\\n\\n<pre>\\n<strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]\\n<strong>Output:</strong> 3\\n<strong>Explanation:</strong> From the picture above, one can see that all of the components of this graph are complete.\\n</pre>\\n\\n<p><strong class=\\\"example\\\">Example 2:</strong></p>\\n\\n<p><strong class=\\\"example\\\"><img alt=\\\"\\\" src=\\\"https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-32-00.png\\\" style=\\\"width: 671px; height: 270px;\\\" /></strong></p>\\n\\n<pre>\\n<strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]\\n<strong>Output:</strong> 1\\n<strong>Explanation:</strong> The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.\\n</pre>\\n\\n<p>&nbsp;</p>\\n<p><strong>Constraints:</strong></p>\\n\\n<ul>\\n\\t<li><code>1 &lt;= n &lt;= 50</code></li>\\n\\t<li><code>0 &lt;= edges.length &lt;= n * (n - 1) / 2</code></li>\\n\\t<li><code>edges[i].length == 2</code></li>\\n\\t<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>\\n\\t<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>\\n\\t<li>There are no repeated edges.</li>\\n</ul>\\n\",\"difficulty\":\"Medium\",\"exampleTestcases\":\"6\\n[[0,1],[0,2],[1,2],[3,4]]\\n6\\n[[0,1],[0,2],[1,2],[3,4],[3,5]]\",\"codeSnippets\":[{\"lang\":\"C++\",\"langSlug\":\"cpp\",\"code\":\"class Solution {\\npublic:\\n    int countCompleteComponents(int n, vector<vector<int>>& edges) {\\n        \\n    }\\n};\"},{\"lang\":\"Java\",\"langSlug\":\"java\",\"code\":\"class Solution {\\n    public int countCompleteComponents(int n, int[][] edges) {\\n        \\n    }\\n}\"},{\"lang\":\"Python\",\"langSlug\":\"python\",\"code\":\"class Solution(object):\\n    def countCompleteComponents(self, n, edges):\\n        \\\"\\\"\\\"\\n        :type n: int\\n        :type edges: List[List[int]]\\n        :rtype: int\\n        \\\"\\\"\\\"\\n        \"},{\"lang\":\"Python3\",\"langSlug\":\"python3\",\"code\":\"class Solution:\\n    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:\\n        \"},{\"lang\":\"C\",\"langSlug\":\"c\",\"code\":\"int countCompleteComponents(int n, int** edges, int edgesSize, int* edgesColSize) {\\n    \\n}\"},{\"lang\":\"C#\",\"langSlug\":\"csharp\",\"code\":\"public class Solution {\\n    public int CountCompleteComponents(int n, int[][] edges) {\\n        \\n    }\\n}\"},{\"lang\":\"JavaScript\",\"langSlug\":\"javascript\",\"code\":\"/**\\n * @param {number} n\\n * @param {number[][]} edges\\n * @return {number}\\n */\\nvar countCompleteComponents = function(n, edges) {\\n    \\n};\"},{\"lang\":\"TypeScript\",\"langSlug\":\"typescript\",\"code\":\"function countCompleteComponents(n: number, edges: number[][]): number {\\n    \\n};\"},{\"lang\":\"PHP\",\"langSlug\":\"php\",\"code\":\"class Solution {\\n\\n    /**\\n     * @param Integer ${'$'}n\\n     * @param Integer[][] ${'$'}edges\\n     * @return Integer\\n     */\\n    function countCompleteComponents(${'$'}n, ${'$'}edges) {\\n        \\n    }\\n}\"},{\"lang\":\"Swift\",\"langSlug\":\"swift\",\"code\":\"class Solution {\\n    func countCompleteComponents(_ n: Int, _ edges: [[Int]]) -> Int {\\n        \\n    }\\n}\"},{\"lang\":\"Kotlin\",\"langSlug\":\"kotlin\",\"code\":\"class Solution {\\n    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {\\n        \\n    }\\n}\"},{\"lang\":\"Dart\",\"langSlug\":\"dart\",\"code\":\"class Solution {\\n  int countCompleteComponents(int n, List<List<int>> edges) {\\n    \\n  }\\n}\"},{\"lang\":\"Go\",\"langSlug\":\"golang\",\"code\":\"func countCompleteComponents(n int, edges [][]int) int {\\n    \\n}\"},{\"lang\":\"Ruby\",\"langSlug\":\"ruby\",\"code\":\"# @param {Integer} n\\n# @param {Integer[][]} edges\\n# @return {Integer}\\ndef count_complete_components(n, edges)\\n    \\nend\"},{\"lang\":\"Scala\",\"langSlug\":\"scala\",\"code\":\"object Solution {\\n    def countCompleteComponents(n: Int, edges: Array[Array[Int]]): Int = {\\n        \\n    }\\n}\"},{\"lang\":\"Rust\",\"langSlug\":\"rust\",\"code\":\"impl Solution {\\n    pub fn count_complete_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {\\n        \\n    }\\n}\"},{\"lang\":\"Racket\",\"langSlug\":\"racket\",\"code\":\"(define/contract (count-complete-components n edges)\\n  (-> exact-integer? (listof (listof exact-integer?)) exact-integer?)\\n  )\"},{\"lang\":\"Erlang\",\"langSlug\":\"erlang\",\"code\":\"-spec count_complete_components(N :: integer(), Edges :: [[integer()]]) -> integer().\\ncount_complete_components(N, Edges) ->\\n  .\"},{\"lang\":\"Elixir\",\"langSlug\":\"elixir\",\"code\":\"defmodule Solution do\\n  @spec count_complete_components(n :: integer, edges :: [[integer]]) :: integer\\n  def count_complete_components(n, edges) do\\n    \\n  end\\nend\"}],\"sampleTestCase\":\"6\\n[[0,1],[0,2],[1,2],[3,4]]\",\"metaData\":\"{\\n  \\\"name\\\": \\\"countCompleteComponents\\\",\\n  \\\"params\\\": [\\n    {\\n      \\\"name\\\": \\\"n\\\",\\n      \\\"type\\\": \\\"integer\\\"\\n    },\\n    {\\n      \\\"type\\\": \\\"integer[][]\\\",\\n      \\\"name\\\": \\\"edges\\\"\\n    }\\n  ],\\n  \\\"return\\\": {\\n    \\\"type\\\": \\\"integer\\\"\\n  }\\n}\"}}}}"
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
