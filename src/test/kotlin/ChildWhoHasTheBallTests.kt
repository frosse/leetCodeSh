import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChildWhoHasTheBallTests {

    @Test
    fun `who has the ball 1 `() {
        val result = numberOfChild(3,5)
        assertEquals(1, result)
    }

    @Test
    fun `who has the ball 2 `() {
        val result = numberOfChild(5,6)
        assertEquals(2, result)
    }

    @Test
    fun `who has the ball 3 `() {
        val result = numberOfChild(4,2)
        assertEquals(2, result)
    }

    @Test
    fun `who has the ball 4 `() {
        val result = numberOfChild(2,3)
        assertEquals(1, result)
    }
}

fun numberOfChild(n: Int, k: Int): Int {
    if (n > k) {
        return k
    }
    val div = k / (n - 1)
    val rem = k % (n -1)
    return when {
        div % 2 == 0 -> rem
        else -> (n-1) - rem
    }
}