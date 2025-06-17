package aquarium
import kotlin.math.PI

open class Aquarium ( var width: Int = 20, var height: Int = 40, var length: Int = 100) {

    // "open" para que pueda ser sobrescrita en clases hijas
    open var volume: Int
        get() = width * height * length / 1000
        set(value) { height = (value * 1000) / (width * length) }

    open var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        val water: Int = numberOfFish * 2000 // cm3
        val tank: Double = water * water * 0.1
        // Ajusta la height del tanque para que cumpla con el volumen necesario.
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank() : Aquarium() {

    override var water: Double
        get() = volume * 0.9
        set(value) {}

    // Sobrescribe el cálculo de volumen con fórmula cilíndrica
    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }

}

fun main() {
    val tank = TowerTank()
    println("TowerTank volume: ${tank.volume}")
    println("TowerTank water: ${tank.water}")
}

