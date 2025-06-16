import java.util.*

fun main (args: Array<String>) {
    println( if (args[0].toInt() < 12 ) "Good morning, Klotin" else "Good night, Klotin")

    feedTheFish()
}

fun feedTheFish() {
    val day = randomDay()
    val food = "Barbecue"
    println("Today is $day and ate $food")
}

fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}