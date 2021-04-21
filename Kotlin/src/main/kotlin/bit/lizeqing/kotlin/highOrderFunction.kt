package bit.lizeqing.kotlin

fun example(func: (String, Int) -> Unit) {
    func("hello", 123)
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

inline fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

fun main() {
    example { s, i ->
        println(s + i)
    }

    val builder = StringBuilder().build {
        append(1)
        append(2)
    }
    println(builder.toString())

    println(num1AndNum2(1, 2) { n1, n2 ->
        n1 + n2
    })

    printString("") { s ->
        println("lambda begin")
        if (s.isEmpty()) {
            return
        }
        println(s)
        println("lambda end")
    }
}
