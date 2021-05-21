package bit.lizeqing.kotlin

import kotlin.reflect.KProperty

fun <T> later(block: () -> T) = Later(block)

class Later<T>(val block: () -> T) {

    var value: T? = null

    operator fun getValue(any: Any?, prop: KProperty<*>) : T {
        if (value == null) {
            value = block()
        }
        return value as T
    }

}

fun main() {
    val a by later {
        println("later(a)")
        1
    }
    lazy {  }
    println("before println(a)")
    println(a)
}