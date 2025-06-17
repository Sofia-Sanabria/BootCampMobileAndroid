package simplespice.abstracto

// Crea un singleton (unica instancia global)
object MobyDickWhale {
    val author = "Sofia Sanabria"
    var jumpHeight = 0.0 // altura del salto

    // Da un valor aleatorio al salto entre 1 y 6 metros.
    fun jump(){
        jumpHeight = (1..5).random() + Math.random()
        println("The whale jumps $jumpHeight meters high!")
    }
}

enum class Color (val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0XFFFF00)
}

// reescribe la herencia (util para usar con when sin necesidad de else)
sealed class Seal

// Subclases que heredan de Seal
class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal( seal: Seal): String {
    return when(seal) {
        // El compilador sabe que no puede ser walrus o seaLion
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

fun main () {
    println(MobyDickWhale.author)
    MobyDickWhale.jump()
    val color = Color.RED
    println(color.rgb)  // Imprime 0xFF0000 en decimal
    val mySeal = SeaLion()
    println(matchSeal(mySeal))

}