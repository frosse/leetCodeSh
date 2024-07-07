import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class WaterBottlesTest {
    @TestFactory
    fun testNumWaterBottles() = listOf(
        DynamicTest.dynamicTest("9 and 3") {
            assertEquals(13, numWaterBottles(9, 3))
        },
        DynamicTest.dynamicTest("15 and 4") {
            assertEquals(19, numWaterBottles(15, 4))
        },
        DynamicTest.dynamicTest("15 and 8") {
            assertEquals(17, numWaterBottles(15, 8))
        }
    )
}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var sum = numBottles
    var emptyBottles: Int
    var rem = 0
    var curr = numBottles
    while (curr > 0) {
        emptyBottles = curr
        curr = (emptyBottles+rem) / numExchange
        rem = (emptyBottles+rem) % numExchange
        sum += curr
    }
    return sum
}
