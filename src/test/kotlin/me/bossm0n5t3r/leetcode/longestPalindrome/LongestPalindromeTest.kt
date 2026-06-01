package me.bossm0n5t3r.leetcode.longestPalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeTest {
    private val sut = LongestPalindrome.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("abccccdd", 7),
                TestData("a", 1),
                TestData("bb", 2),
                TestData("abcba", 5),
                TestData(
                    """
                    civilwartestingwhethertha
                    tnaptionoranynartionsocon
                    ceivedandsodedicatedcanlo
                    ngendureWeareqmetonagreat
                    battlefiemldoftzhatwarWeh
                    avecometodedicpateaportio
                    nofthatfieldasafinalresti
                    ngplaceforthosewhoheregav
                    etheirlivesthatthatnation
                    mightliveItisaltogetherfa
                    ngandproperthatweshoulddo
                    thisButinalargersenseweca
                    nnotdedicatewecannotconse
                    cratewecannothallowthisgr
                    oundThebravelmenlivingand
                    deadwhostruggledherehavec
                    onsecrateditfaraboveourpo
                    orponwertoaddordetractTgh
                    eworldadswfilllittlenotle
                    norlongrememberwhatwesayh
                    erebutitcanneverforgetwha
                    ttheydidhereItisforusthel
                    ivingrathertobededicatedh
                    eretotheulnfinishedworkwh
                    ichtheywhofoughtherehavet
                    husfarsonoblyadvancedItis
                    ratherforustobeherededica
                    tedtothegreattdafskremain
                    ingbeforeusthatfromtheseh
                    onoreddeadwetakeincreased
                    devotiontothatcauseforwhi
                    chtheygavethelastpfullmea
                    sureofdevotionthatwehereh
                    ighlyresolvethatthesedead
                    shallnothavediedinvaintha
                    tthisnationunsderGodshall
                    haveanewbirthoffreedomand
                    thatgovernmentofthepeople
                    bythepeopleforthepeoplesh
                    allnotperishfromtheearth
                    """
                        .trimIndent()
                        .replace("\n", ""),
                    983,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.longestPalindrome(test.s)) }
    }
}
