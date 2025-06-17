package simplespice

class SimpleSpice {
    val name: String = "Curry"
    val spiciness: String = "mild"

    // propiedad que devuelva un valor según el nivel de picante:
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}

fun main() {
    val spice = SimpleSpice()
    println("Nombre: ${spice.name}")
    println("Nivel de picante (heat): ${spice.heat}")
}
