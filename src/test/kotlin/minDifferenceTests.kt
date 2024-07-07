import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinDifference {

    @Test
    fun `min difference`() {
        val input = intArrayOf(3, 100, 20)
        val result = minDifference(input)
        assertEquals(0, result)
    }

    @Test
    fun `zero length input`() {
        val input = intArrayOf()
        val result = minDifference(input)
        assertEquals(0, result)
    }

    @Test
    fun `one length input`() {
        val input = intArrayOf(1)
        val result = minDifference(input)
        assertEquals(0, result)
    }

    @Test
    fun `two length input`() {
        val input = intArrayOf(1, 2)
        val result = minDifference(input)
        assertEquals(0, result)
    }

    // The minimum difference possible is obtained by removing three elements
    // between the three smallest and three largest values in the array.
    // 234 smallest
    // 345 largest
    @Test
    fun `min difference2`() {
        val input = intArrayOf(1, 5, 0, 10, 14)
        val result = minDifference(input)
        assertEquals(1, result)
    }

}

fun calcMinDifForCase(input: List<Int>, case: List<Pair<Int, Int>>): Int {
    val arr = input.toMutableList()
    case.forEach { pair ->
        arr[pair.first] = arr[pair.second]
    }

    return arr.max() - arr.min()
}

fun minDifference(nums: IntArray): Int {
    if (nums.size < 4) return 0

    val length = nums.size
    val cases = listOf(
        listOf(Pair(0, length - 1), Pair(1, length - 2), Pair(2, length - 2)),
        listOf(Pair(0, length - 2), Pair(1, length - 2), Pair(length - 1, length - 2)),
        listOf(Pair(length - 1, 0), Pair(length - 2, 0), Pair(length - 3, 0)),
        listOf(Pair(length - 1, 1), Pair(length - 2, 1), Pair(0, 1))
    )
    return cases.minOf { case ->
        calcMinDifForCase(nums.sorted(), case)
    }

}