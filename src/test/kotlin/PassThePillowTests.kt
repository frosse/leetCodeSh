import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PassThePillowTests {
    @Test
    fun `pass the pillow`() {
        val result = passThePillow(4, 5)
        assertEquals(2, result)
    }

    @Test
    fun `pass the pillow 2`() {
        val result = passThePillow(3, 2)
        assertEquals(3, result)
    }

    @Test
    fun `pass the pillow 3`() {
        val result = passThePillow(18, 38)
        assertEquals(5, result)
    }

    @Test
    fun `pass the pillow 4`() {
        val result = passThePillow(2, 341)
        assertEquals(2, result)
    }

    @Test
    fun `pass the pillow 5`() {
        val result = passThePillow(26, 1000)
        assertEquals(1, result)
    }
}

fun passThePillow(n: Int, time: Int): Int {
    if (n > time) {
        return time + 1
    }
    val asd = time / (n - 1)
    val div = time % (n -1)
    if (asd % 2 == 0) {

        if (div == 0) {
            return 1
        }
        return div + 1
    } else {

        if (div == 0) {
            return n
        }
        return n - div
    }
}