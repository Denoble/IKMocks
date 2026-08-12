

data class MyNode(val data:Int, var nextNode:MyNode? = null)

fun swapAdjacentNodes(head:MyNode?):List<Int>{
    val result = mutableListOf<Int>()
    if(head == null) return result.toList()
    var tempNode = head
    var canSwap = true
    var previous:MyNode?
    while(tempNode?.nextNode != null){
        previous = tempNode
        tempNode = tempNode.nextNode
        if(canSwap){
            tempNode?.data?.let{
                result.add(it)
            }
            previous.data.let{
                result.add( it)
            }
        }
        canSwap = !canSwap

    }
    return result.toList()
}

fun main() {

    var testData1 =  MyNode(0,null)
    var testData5 = MyNode(5,null)
    var testData4 = MyNode(4,testData5)
    var testData3 = MyNode(3,testData4)
    var testData2 = MyNode(1,testData3)
    testData1.nextNode = testData2
    val test1 =  swapAdjacentNodes(null)
    val test2 = swapAdjacentNodes(testData1)
    val test3 = swapAdjacentNodes(MyNode(6,null))

    println("printing test 1 ${test1}")
    println("printing test 2 ${test2}")
    println("printing test 3  ${test3}")
}