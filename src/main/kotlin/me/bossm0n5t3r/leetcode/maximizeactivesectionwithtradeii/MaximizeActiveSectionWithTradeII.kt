package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradeii

class MaximizeActiveSectionWithTradeII {
    class Solution {
        private data class Group(val start: Int, val length: Int)

        fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
            // s 전체에 있는 1의 개수, trade는 1의 위치를 옮기므로 기준값이 됨
            val ones = s.count { it == '1' }

            // zeroGroups: 연속된 0 블록들의 (시작 인덱스, 길이) 목록
            // zeroGroupIndex[i]: i번째 문자가 속하거나 앞서는 0-블록의 인덱스
            val (zeroGroups, zeroGroupIndex) = getZeroGroups(s)

            // 0-블록이 2개 미만이면 1 0^a 1^b 0^c 1 패턴을 만들 수 없으므로 trade 불가
            if (zeroGroups.size < 2) {
                return List(queries.size) { ones }
            }

            // 인접한 두 0-블록의 길이 합을 저장하는 Sparse Table
            // 구간 [l, r] 안에서 완전히 포함되는 인접 쌍 중 최대 이득을 O(1)에 구함
            val st = SparseTable(getZeroMergeLengths(zeroGroups))

            return queries.map { query ->
                val l = query[0]
                val r = query[1]

                // l이 속한 0-블록에서 l부터 그 블록 끝까지의 길이
                // s[l] == '1'이면 zeroGroupIndex[l]은 앞선 0-블록을 가리키지만
                // 이 값은 s[l] == '0'인 경우에만 사용되므로 문제없음
                val left =
                    if (zeroGroupIndex[l] == -1) {
                        -1
                    } else {
                        zeroGroups[zeroGroupIndex[l]].length -
                            (l - zeroGroups[zeroGroupIndex[l]].start)
                    }

                // r이 속한 0-블록에서 그 블록 시작부터 r까지의 길이
                // 마찬가지로 s[r] == '0'일 때만 사용됨
                val right =
                    if (zeroGroupIndex[r] == -1) {
                        -1
                    } else {
                        r - zeroGroups[zeroGroupIndex[r]].start + 1
                    }

                // 쿼리 끝이 1이면 r 이전 마지막 0-블록까지가 범위 안
                // 쿼리 끝이 0이면 r이 속한 0-블록은 부분만 포함되므로 한 칸 앞으로
                val endGroupIndex = if (s[r] == '1') zeroGroupIndex[r] else zeroGroupIndex[r] - 1

                // 인접한 0-블록 쌍의 인덱스 범위로 변환
                // zeroMergeLengths[i] = zeroGroups[i] + zeroGroups[i+1] 이므로
                // 블록 인덱스 [start, end]에 대응하는 쌍 인덱스는 [start, end - 1]
                val (startAdjacentGroupIndex, endAdjacentGroupIndex) =
                    mapToAdjacentGroupIndices(zeroGroupIndex[l] + 1, endGroupIndex)

                // trade를 안 하면 원래 1의 개수가 답
                var activeSections = ones

                // 경우 1: l과 r이 인접한 두 0-블록에 각각 걸쳐 있음
                // 1 0...0 [l 0...0 1 0...0 r] 0...0 1 패턴에서 l부터 r까지의 부분을 trade
                if (s[l] == '0' && s[r] == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                    activeSections = maxOf(activeSections, ones + left + right)
                } else if (startAdjacentGroupIndex <= endAdjacentGroupIndex) {
                    // 경우 2: 쿼리 범위 안에 완전히 포함된 인접 0-블록 쌍이 있음
                    activeSections =
                        maxOf(
                            activeSections,
                            ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex),
                        )
                }

                // 경우 3: l이 0-블록 중간에 있고, 오른쪽 다음 0-블록 전체가 범위 안
                if (s[l] == '0' && zeroGroupIndex[l] + 1 <= endGroupIndex) {
                    activeSections =
                        maxOf(
                            activeSections,
                            ones + left + zeroGroups[zeroGroupIndex[l] + 1].length,
                        )
                }

                // 경우 4: r이 0-블록 중간에 있고, 왼쪽 이전 0-블록 전체가 범위 안
                if (s[r] == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {
                    activeSections =
                        maxOf(
                            activeSections,
                            ones + right + zeroGroups[zeroGroupIndex[r] - 1].length,
                        )
                }

                activeSections
            }
        }

        private fun getZeroGroups(s: String): Pair<List<Group>, IntArray> {
            val zeroGroups = mutableListOf<Group>()
            val zeroGroupIndex = IntArray(s.length) { -1 }

            for (i in s.indices) {
                if (s[i] == '0') {
                    if (i > 0 && s[i - 1] == '0') {
                        // 이전 문자와 같은 0-블록이면 길이만 늘림
                        val last = zeroGroups.last()
                        zeroGroups[zeroGroups.size - 1] = last.copy(length = last.length + 1)
                    } else {
                        // 새로운 0-블록 시작
                        zeroGroups.add(Group(i, 1))
                    }
                }
                // 1이면 마지막 0-블록 인덱스를, 0이면 현재 0-블록 인덱스를 기록
                // 1인데 앞에 0-블록이 없으면 -1
                zeroGroupIndex[i] = zeroGroups.size - 1
            }

            return Pair(zeroGroups, zeroGroupIndex)
        }

        // 인접한 두 0-블록의 길이 합 배열
        // zeroMergeLengths[i] = zeroGroups[i].length + zeroGroups[i + 1].length
        private fun getZeroMergeLengths(zeroGroups: List<Group>): IntArray {
            return IntArray(zeroGroups.size - 1) {
                zeroGroups[it].length + zeroGroups[it + 1].length
            }
        }

        // 0-블록 인덱스 범위 [startGroupIndex, endGroupIndex]를
        // 인접 쌍 인덱스 범위 [startGroupIndex, endGroupIndex - 1]로 변환
        private fun mapToAdjacentGroupIndices(
            startGroupIndex: Int,
            endGroupIndex: Int,
        ): Pair<Int, Int> {
            return Pair(startGroupIndex, endGroupIndex - 1)
        }

        // 구간 최대값을 O(1)에 반환하는 Sparse Table
        private class SparseTable(nums: IntArray) {
            private val n: Int = nums.size
            private val st: Array<IntArray>

            init {
                val log =
                    if (n == 0) {
                        0
                    } else {
                        n.takeHighestOneBit().countTrailingZeroBits() + 1
                    }
                st = Array(log) { IntArray(n + 1) }
                nums.copyInto(st[0])

                // st[i][j] := nums[j..j + 2^i - 1] 구간의 최대값
                for (i in 1 until log) {
                    val half = 1 shl (i - 1)
                    val rangeLength = 1 shl i
                    for (j in 0 until n - rangeLength + 1) {
                        st[i][j] = maxOf(st[i - 1][j], st[i - 1][j + half])
                    }
                }
            }

            fun query(l: Int, r: Int): Int {
                val length = r - l + 1
                // length 이하의 최대 2의 거듭제곱 길이를 갖는 두 구간의 최대값을 합쳐서
                // [l, r]을 완전히 덮음
                val i = length.takeHighestOneBit().countTrailingZeroBits()
                return maxOf(st[i][l], st[i][r - (1 shl i) + 1])
            }
        }
    }
}
