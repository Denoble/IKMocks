data class MyNode(val data: Int, var nextNode: MyNode? = null)

fun swapAdjacentNodes(head: MyNode?): MyNode? {
    var newHead: MyNode? = null
    var curNode: MyNode? = null
    if (head == null) return null
    var tempNode = head
    var canSwap = true
    var previous: MyNode?
    while (tempNode?.nextNode != null) {
        previous = tempNode
        tempNode = tempNode.nextNode
        if (canSwap) {
            previous.nextNode = null
            val item = tempNode?.data ?: 0
            val interNode = MyNode(item, previous)
            if (newHead == null) {
                newHead = interNode
                curNode = previous
            } else {
                curNode?.nextNode = interNode
                curNode = previous
            }
        }
        canSwap = !canSwap
    }
    return newHead
}


fun main() {
    val testData1 = MyNode(1, null)
    val testData9 = MyNode(9, null)
    val testData8 = MyNode(8, testData9)
    val testData7 = MyNode(7, testData8)
    val testData6 = MyNode(6, testData7)
    val testData5 = MyNode(5, testData6)
    val testData4 = MyNode(4, testData5)
    val testData3 = MyNode(3, testData4)
    val testData2 = MyNode(2, testData3)

    testData1.nextNode = testData2
    var test1 = swapAdjacentNodes(null)
    var test2 = swapAdjacentNodes(testData1)
    var test3 = swapAdjacentNodes(MyNode(6, null))
    val list = mutableListOf<Int>()

    println("printing test 1 ")
    while (test1 != null) {
        list.add(test1.data)
        test1 = test1.nextNode
    }
    println(list)
    list.clear()
    println("printing test 2 ")
    while (test2 != null) {
        list.add(test2.data)
        test2 = test2.nextNode
    }
    println(list)
    list.clear()
    println("printing test 3  ")
    while (test3 != null) {
        list.add(test3.data)
        test3 = test3.nextNode
    }
    println(list)
    list.clear()
}