package me.bossm0n5t3r.leetcode.encodeAndDecodeTinyURL

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class EncodeAndDecodeTinyURLTest {
    private val encodeAndDecodeTinyURL = EncodeAndDecodeTinyURL.Codec()
    private val longUrl = "https://leetcode.com/problems/design-tinyurl"

    @AfterEach fun cleanUp() = encodeAndDecodeTinyURL.cleanUp()

    @Test
    fun `encode - longUrl 을 shortUrl 로 리턴`() {
        val shortUrl = encodeAndDecodeTinyURL.encode(longUrl)
        assertThat(longUrl.length).isGreaterThan(shortUrl.length)
    }

    @Test
    fun `encode - 서로 다른 두 longUrl 들은 각각 다른 shortUrl 들로 리턴`() {
        val oneLongUrl = "https://leetcode.com/problems/design-tinyurl-one"
        val theOtherLongUrl = "https://leetcode.com/problems/design-tinyurl-the-other"
        assertThat(encodeAndDecodeTinyURL.encode(oneLongUrl))
            .isNotEqualTo(encodeAndDecodeTinyURL.encode(theOtherLongUrl))
    }

    @Test
    fun `encode - 하나의 longUrl 은 하나의 shortUrl 만 리턴`() {
        val shortUrl = encodeAndDecodeTinyURL.encode(longUrl)
        val maybeAnotherShortUrl = encodeAndDecodeTinyURL.encode(longUrl)
        assertThat(shortUrl).isEqualTo(maybeAnotherShortUrl)
        assertThat(encodeAndDecodeTinyURL.numberOfKey()).isEqualTo(1)
    }

    @Test
    fun `decode - longUrl 을 넣어 받은 shortUrl 을 decode 하면 다시 원래의 longUrl 을 리턴`() {
        val shortUrl = encodeAndDecodeTinyURL.encode(longUrl)
        val decodedShortUrl = encodeAndDecodeTinyURL.decode(shortUrl)
        assertThat(longUrl).isEqualTo(decodedShortUrl)
    }
}
