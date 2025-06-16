fun main () {
    println("What's your mood today")
    val mood = readLine()!! // Verifica valores nulos
    println(whatShouldIDoToday(mood))
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "sunny",
    temperature: Int = 24
): String {

    return when {
        isPerfectForWalk(mood, weather) -> "Go for a walk"
        isColdRainySad(mood, weather, temperature) -> "Stay in bed"
        isVeryHot(temperature) -> "Go swimming"
        else -> "Stay home and read."    }
}

fun isVeryHot(temperature: Int) = temperature > 35
fun isColdRainySad(mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0
fun isPerfectForWalk(mood: String, weather: String) =
    mood == "happy" && weather == "sunny"