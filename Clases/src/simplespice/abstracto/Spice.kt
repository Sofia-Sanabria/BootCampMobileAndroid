package simplespice.abstracto

// Interfaz para color
interface SpiceColor {
    val color: Color
}

// Interfaz para comportamiento comun
interface Grinder {
    fun grind()
}

// Objeto Singleton (se crea una sola vez)
object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

// Clase abstracta Spice (no se puede instanciar directamente)
// con propiedad de color y metodo abstracto

// sealed permite al compilador conocer todas sus subclases posibles
sealed class Spice (
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor
) : SpiceColor by color { // Spice usa delegate by color
    abstract fun prepareSpice()
}

// Clase que hereda de Spice e implementa Grinder
class Curry(spiciness: String) : Spice("Curry", spiciness), Grinder {

    override fun grind() {
        println("Grinding the curry into powder")
    }
    override fun prepareSpice() {
        grind()
    }
}

// Funcion principal
fun main() {
    val curry = Curry("hot")
    println("Curry color is ${curry.color}")
    curry.prepareSpice()
}