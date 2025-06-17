package simplespice

class Spice (val name: String, val spiciness: String = "mild"){
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }
    // block que imprime los valores al crear el objeto
    init {
        println("Spice created: name=$name, spiciness=$spiciness, heat=$heat")
    }
}

// Funcion auxiliar para sal
fun makeSalt() = Spice("Salt")

fun main() {
    // Crear una instancia de Spice
    val curry = Spice("Curry", "medium")

    // Crear una lista de objetos Spice
    val spiceList = listOf(
        Spice("Pepper", "spicy"),
        Spice("Chili", "very spicy"),
        Spice("Paprika", "mild"),
        makeSalt(),
        Spice("Wasabi", "extremely spicy")
    )

    // Filtrar las especias menos o igual de picantes
    val mildOrLess = spiceList.filter { it.heat <= 5 }
    println("Spices with heat <= 5:")
    mildOrLess.forEach { println(it.name) }


}