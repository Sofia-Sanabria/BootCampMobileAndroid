package simplespice.container

// Clase de datos con dos propiedades
data class Spice (val name: String, val spiciness: String = "mild") {}

// SpiceContainer contiene una instancia de Spice.
data class SpiceContainer(val spice: Spice) {
    // propiedad label que se calcula a partir del name de la especia
    val label: String
        get() = spice.name
}

fun main() {
    val containers = listOf(
        SpiceContainer(Spice("Curry", "hot")),
        SpiceContainer(Spice("Pepper", "medium")),
        SpiceContainer(Spice("Salt"))
    )

    // imprimir la label de cada contenedor.
    for (container in containers) {
        println(container.label)
    }
}
