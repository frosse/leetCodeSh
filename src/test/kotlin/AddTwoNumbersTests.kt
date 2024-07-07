import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AddTwoNumbersTests {

    @Test
    fun `add two numbers`() {
        val resultList = ListNode(7).addNode(ListNode(0).addNode(ListNode(8)))
        //[2,4,3],
        val l1 = ListNode(2).addNode(ListNode(4).addNode(ListNode(3)))

        println(l1)

        val l2 = ListNode(5).addNode(ListNode(6).addNode(ListNode(4)))
        // l2 = [5,6,4]
        val result = addTwoNumbers(l1,l2)
        assertEquals(resultList, result)
    }

    @Test
    fun `add two zeroes`() {
        val l1 = ListNode(0)
        val l2 = ListNode(0)
        val resultList = ListNode(0)
        val result = addTwoNumbers(l1,l2)
        assertEquals(resultList, result)
    }

    @Test
    fun `add uneven lists`() {

        val l1 = ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9)))))))
        val l2 =ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9)))))
        val resultList = ListNode(8).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(9).addNode(ListNode(0).addNode(ListNode(0).addNode(ListNode(0).addNode(ListNode(1))))))))
        val result = addTwoNumbers(l1,l2)
        println("rasdsadsadasd ${result!!.`val`}")
        assertEquals(resultList, result)
    }

}

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.


 class ListNode(var `val`: Int, var next: ListNode? = null) {

    fun addNode( num: ListNode): ListNode {
        this.next = num
        return this
    }

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as ListNode

         if (`val` != other.`val`) return false
         var l1 = this
         var l2: ListNode = other
         while (l1.next != null && l2.next != null) {
             l1 = l1.next!!
             l2 = l2.next!!
             if (l1.`val` != l2.`val`) return false
         }

         return true
     }

 }

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var tmp1 = l1
    var tmp2 = l2
    var carried = 0
    var tmp3: ListNode?
    if (tmp1!!.`val` + tmp2!!.`val` >= 10) {
        tmp3 = ListNode(tmp1.`val` + tmp2.`val` -10)
        println("first over 10: ${tmp1.`val` + tmp2.`val` -10}")
        carried = 1
    } else {
        tmp3 = ListNode(tmp1.`val` + tmp2.`val`)
    }
    val head = tmp3

    println("result `val`: ${tmp3.`val`}")

    while (tmp1!!.next != null ) {
        println("result `val` 1111: ${tmp3!!.`val`}")

        tmp1 = tmp1.next
        var val2 = 0
        tmp2 = tmp2?.next
        var val1 = 0
        if (tmp1 != null) {
            val1 = tmp1.`val`
        }

        if (tmp2 != null) {
            val2 = tmp2.`val`
        }
        println("tmp2 `val` $val2")

        if (val1 + val2 >= 10) {
            println("over 10: ${val1+val2-10 +carried}")
            println("result HERE: ${tmp3!!.`val`}")
            tmp3!!.addNode(ListNode(val1+val2-10 +carried))
            println("tmp3 next ${tmp3.next!!.`val`}")
            carried = 1

        } else {
            println(val1+val2+carried)

            tmp3!!.addNode(ListNode(val1 + val2 +carried))
            carried =0

        }

        println("result HERE: ${tmp3!!.`val`}")

        tmp3 = tmp3.next

    }

    return head
}