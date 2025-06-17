package aquarium.decorations

fun main (args: Array<String>) {
    makeDecorations()
}

// Funcion que crea y maneja objetos de decoracion
fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1)
    val d2 = Decorations("slate")
    println(d2)
    val d3 = Decorations("slate")
    println(d3)

    // Comparacion entre objetos
    println(d1.equals(d2)) // false
    println(d3.equals(d2)) // true

    // data class genera un método para clonar objetos.
    val d4 : Decorations = d3.copy()
    println(d3)
    println(d4)

    // Crear un objeto con varias propiedades
    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    // Destructuring (descomponer en variables individuales)
    val (rock: String, wood: String, diver: String) = d5
    println(rock)
    println(wood)
    println(diver)
}

// data class genera automáticamente:
// equals(), hashCode(), toString(), copy(), component1().

// Clase de datos con una sola propiedad rocks
data class Decorations (val rocks: String) {}

// Clase de datos con tres propiedades
data class Decorations2 (val rocks: String, val wood: String, val diver: String) {}
