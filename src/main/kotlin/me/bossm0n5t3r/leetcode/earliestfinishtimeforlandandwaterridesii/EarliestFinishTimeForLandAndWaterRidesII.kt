package me.bossm0n5t3r.leetcode.earliestfinishtimeforlandandwaterridesii

class EarliestFinishTimeForLandAndWaterRidesII {
    class Solution {
        fun earliestFinishTime(
            landStartTime: IntArray,
            landDuration: IntArray,
            waterStartTime: IntArray,
            waterDuration: IntArray,
        ): Int {
            // land를 먼저 타고 water를 나중에 타는 경우와, water를 먼저 타고 land를 나중에 타는 경우 중 최솟값을 반환한다.
            return minOf(
                // land -> water 순서로 탔을 때의 가장 빠른 종료 시각을 계산한다.
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                // water -> land 순서로 탔을 때의 가장 빠른 종료 시각을 계산한다.
                solve(waterStartTime, waterDuration, landStartTime, landDuration),
            )
        }

        // first 놀이기구를 먼저 탄 뒤 second 놀이기구를 타는 경우의 최소 종료 시각을 구한다.
        private fun solve(
            firstStart: IntArray,
            firstDuration: IntArray,
            secondStart: IntArray,
            secondDuration: IntArray,
        ): Int {
            // first는 종료 시각이 작은 순서대로 보면서 투포인터의 기준 시간으로 사용한다.
            val firstRides = firstStart.toRides(firstDuration).sortedBy { it.finish }
            // second는 시작 시각이 작은 순서대로 정렬해 first 종료 시각 이하인 것들을 포인터로 흡수한다.
            val secondRides = secondStart.toRides(secondDuration).sortedBy { it.start }
            // suffixMinFinish[i]는 secondRides[i..끝] 중 start + duration의 최솟값이다.
            val suffixMinFinish = buildSuffixMinFinish(secondRides)

            // 지금까지 찾은 전체 최소 종료 시각이다.
            var result = Int.MAX_VALUE
            // 현재 first 종료 시각 이전에 시작 가능한 second들 중 가장 짧은 duration이다.
            var minAvailableSecondDuration = Int.MAX_VALUE
            // secondRides에서 아직 처리하지 않은 첫 번째 인덱스이다.
            var secondIndex = 0

            // first를 종료 시각 오름차순으로 하나씩 선택한다.
            for (firstRide in firstRides) {
                // first를 먼저 탔을 때의 종료 시각이다.
                val firstFinish = firstRide.finish

                // firstFinish 시점에 이미 시작 가능한 second들을 모두 처리한다.
                while (
                    secondIndex < secondRides.size && secondRides[secondIndex].start <= firstFinish
                ) {
                    // 이미 시작 가능한 second는 기다릴 필요가 없으므로 duration이 가장 짧은 것만 유지하면 된다.
                    minAvailableSecondDuration =
                        minOf(minAvailableSecondDuration, secondRides[secondIndex].duration)
                    // 현재 second를 처리했으므로 다음 second로 이동한다.
                    secondIndex++
                }

                // 시작 가능한 second가 하나라도 있으면 firstFinish + 최소 duration으로 답을 갱신한다.
                if (minAvailableSecondDuration != Int.MAX_VALUE) {
                    result = minOf(result, firstFinish + minAvailableSecondDuration)
                }
                // 아직 시작하지 않은 second들은 기다려야 하므로 start + duration의 suffix 최솟값으로 답을 갱신한다.
                result = minOf(result, suffixMinFinish[secondIndex])
            }

            // first -> second 순서에서 가능한 최소 종료 시각을 반환한다.
            return result
        }

        // rides를 start 오름차순으로 정렬한 상태에서 각 위치 이후의 최소 finish 값을 만든다.
        private fun buildSuffixMinFinish(rides: List<Ride>): IntArray {
            // 마지막에 Int.MAX_VALUE를 둬서 남은 ride가 없는 경우도 안전하게 처리한다.
            val suffixMinFinish = IntArray(rides.size + 1) { Int.MAX_VALUE }
            // 뒤에서부터 보며 현재 ride의 finish와 오른쪽 suffix 최솟값 중 작은 값을 저장한다.
            for (i in rides.lastIndex downTo 0) {
                suffixMinFinish[i] = minOf(rides[i].finish, suffixMinFinish[i + 1])
            }
            // 완성된 suffix 최솟값 배열을 반환한다.
            return suffixMinFinish
        }

        // start 배열과 duration 배열을 Ride 목록으로 묶는다.
        private fun IntArray.toRides(duration: IntArray): List<Ride> {
            // 같은 인덱스의 start와 duration을 하나의 Ride로 변환한다.
            return this.zip(duration) { start, duration -> Ride(start, duration) }
        }

        // 놀이기구 하나의 시작 시각과 소요 시간을 표현한다.
        private data class Ride(val start: Int, val duration: Int) {
            // 이 놀이기구 하나만 탔을 때의 종료 시각이다.
            val finish: Int
                // 종료 시각은 시작 시각 + 소요 시간이다.
                get() = start + duration
        }
    }
}
