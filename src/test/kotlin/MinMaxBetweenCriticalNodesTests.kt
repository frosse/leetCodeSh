import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertContentEquals

class MinMaxBetweenCriticalNodesTests {

    @Test
    fun `No critical points`() {
        //[3,1]

        val input = LinkedList().append(3).append(1)
        val expected = intArrayOf(-1, -1)
        val result = nodesBetweenCriticalPoints(input.head)

        assertContentEquals(expected, result)
    }

    @Test
    fun `three critical points`() {
        // head = [5,3,1,2,5,1,2]
        val input = LinkedList().append(5).append(3).append(1).append(2).append(5).append(1).append(2)
        val expected = intArrayOf(1, 3)
        val result = nodesBetweenCriticalPoints(input.head)
        assertContentEquals(expected, result)

    }

    // [1,3,2,2,3,2,2,2,7]
    @Test
    fun `two critical points`() {
        val input =
            LinkedList().append(1).append(3).append(2).append(2).append(3).append(2).append(2).append(2).append(7)
        val expected = intArrayOf(3, 3)
        val result = nodesBetweenCriticalPoints(input.head)
        assertContentEquals(expected, result)
    }

    @Test
    fun `asda`() {
        val input = LinkedList().append(2).append(2).append(1).append(3)
        val expected = intArrayOf(-1, -1)
        val result = nodesBetweenCriticalPoints(input.head)
        assertContentEquals(expected, result)
    }
}

fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
    var tmp: ListNode = head ?: return intArrayOf(-1, -1)
    var prevValue: Int? = null
    val criticalNodeIndex = mutableListOf<Int>()
    var counter = 1
    var lastCriticalNode = -1
    var minValue = Int.MAX_VALUE
    while (tmp.next != null) {
        if (prevValue != null) {
            if (tmp.`val` > prevValue && tmp.`val` > tmp.next!!.`val`
                || tmp.`val` < prevValue && tmp.`val` < tmp.next!!.`val`) {
                criticalNodeIndex.add(counter)
                if ( lastCriticalNode == -1) {
                    lastCriticalNode = counter
                } else {
                    if (abs(lastCriticalNode - counter) < minValue) minValue =abs(lastCriticalNode - counter)
                    lastCriticalNode = counter

                }
            }
        }
        prevValue = tmp.`val`
        counter++
        tmp = tmp.next!!
    }
    if (criticalNodeIndex.size < 2) return intArrayOf(-1, -1)

println(criticalNodeIndex)
    val sorted = criticalNodeIndex.sorted()
    val max = abs(sorted.first() - sorted.last())
    return intArrayOf(minValue, max)
}

class LinkedList() {
    var head: ListNode? = null
    private var size: Int = 0
    private var tail: ListNode? = null
    private fun isEmpty(): Boolean = size == 0

    fun push(value: Int): LinkedList = apply {
        head = ListNode(`val` = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: Int): LinkedList = apply {
        if (isEmpty()) {
            push(value)
            return this
        }
        val newNode = ListNode(`val` = value)
        tail!!.next = newNode
        tail = newNode
        size++
    }
}
