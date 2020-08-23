import scala.collection.mutable

var stack = mutable.Stack[Int]()
stack.push(1)
stack.push(2)
stack.push(3)
stack.head
stack.last

val queue = mutable.Queue[Int]()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
queue.head
queue.last

"babaa".substring(0,1)
"babaa".substring(1,2)
"babaa".substring(2)

"babaa".substring(0,1)
"babaa".substring(1,3)
"babaa".substring(3)

"babaa".substring(0,1)
"babaa".substring(1,4)
"babaa".substring(4)