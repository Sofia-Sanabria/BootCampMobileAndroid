package aquarium

// Funcion Principal
fun main(args: Array<String>) {
    delegate()
    val shark = Shark()
    val pleco = Plecostomus()
    val plecoDelegate = PlecostomusDelegate()

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()

    println("Plecostomus (delegated): ${plecoDelegate.color}")
    plecoDelegate.eat()
}

// Esta funcion crea un pez Plecostomus y muestra su color y comportamiento
fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

// Interfaz que define una accion del pez: comer
interface  FishAction {
    fun eat()
}

// Interfaz que define el color del pez
interface FishColor {
    val color: String
}

// Clase abstracta que los peces deben extender y definir su color
abstract class AquariumFish {
    abstract val color: String
}

// Clase tiburon que extiende de AquariumFish e implementa FishAction
class Shark: AquariumFish(), FishAction {
    override val color = "gray"

    // Define su forma de comer
    override fun eat() {
        println("hunt and eat fish")
    }
}

// Clase que extiende de AquariumFish e implementa FishAction
class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"

    // Define su forma de comer
    override fun eat() {
        println("munch on algae")
    }
}


// Clase que usa delegacion para implementar FishAction y FishColor
class PlecostomusDelegate(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("a lot of algae"), // Delega eat() en otra clase
        FishColor by fishColor // Delega color en un objeto FishColor

// Objeto Singleton que representa el color dorado
object GoldColor: FishColor {
    override val color = "gold"
}

// Objeto Singleton que representa el color rojo
object RedColor: FishColor {
    override val color ="red"
}

// Clase que implementa la acción de comer
class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food) // Imprime lo que come
    }
}