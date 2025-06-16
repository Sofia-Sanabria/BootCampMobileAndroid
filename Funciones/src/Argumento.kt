fun main (args: Array<String>) {
    println("Hello, ${args[0]}")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temp = 10
    val isHot = if (temp > 50 ) true else false
    println(isHot)

    val message = "You are ${ if (temp > 50) "fired" else "safe" } fish"
    println(message)

}