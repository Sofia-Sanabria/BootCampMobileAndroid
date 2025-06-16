import kotlin.math.pow

fun main() {
    println("Hello Klotin")

    for (i in 1..5) {
        println("i = $i")
    }

    val boxed: Number = 1
    boxed.toLong()

    val b: Byte = 50
    val i: Int = b.toInt()

    val address : Int? = null
    val amount : Double? = 10.0
    val lostOfFish: List<String>? =  null

    var list: List<String?>? = listOf(null, null)
    list?.size

    // Si comienzas con 2 peces y se reproducen dos veces, teniendo 71 crías la primera vez
    // y 233 la segunda vez, y luego 13 peces son devorados por una anguila hambrienta, ¿cuántos peces quedan?
    // ¿Cuántos acuarios necesitas si puedes tener 30 peces por acuario?

    val total = (2.plus(71).plus(233).minus(13))
    val acuarios = total.div(30)
    println("Peces: $total, Acuarios: $acuarios")

    var redColor = "Rojo"
    redColor = "Azul"

    val blackColor = "Negro"
//    blackColor = "Gris" //    No se puede reasignar un 'val'

//    redColor = null // String no admite null

    // Strings de tipo anulables
    var greenColor: String? = null
    val blueColor = null as String?

    // Lista con valores nulos
    val lista1 = listOf<String?>(null, null) // 2 elementos
    val lista2: List<String>? = null // Todos los elementos

    // Crea una variable de tipo Int? llamada nullTest,
    // asígnale null, y usa una verificación nula que:
    //
    //Aumente su valor en 1 si no es null.
    //Devuelva 0 si es null.

    val nullTest: Int? = null
    val resultado = nullTest?.plus(1) ?: 0 // Si el valor a la izquierda es null, usa lo de la derecha”
    println(resultado)

    if (i < acuarios) {
        println(" Good ratio!")
    } else if (i > acuarios){
        println(" Bad ratio!")
    }

    val fish = 50
    if (fish in i..100) println(fish)

    when (fish) {
        0 -> println("Empty tank")
        50 -> println("Full tank")
        else -> println("Perfect")
    }

    val array = Array(7){ 1000.0.pow(it) }
    val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte",
        "terabyte", "petabyte", "exabyte")
    for ((i, value) in array.withIndex()) {
        println("1 ${sizes[i]} = ${value.toLong()} bytes")
    }

    // Arreglo de enteros
    val numbers = arrayOf(11, 12, 13, 14, 15)

    // Lista mutable vacia para string
    var stringList = mutableListOf<String>()

    // Convertir cada numero en string
    for (number in numbers) {
        stringList.add(number.toString())
    }

    println(stringList)

    val string = stringList[0]

    println(string)
    println(string + 1) // Concatenacion

    val numero = string.toInt()

    println(numero + 1) // suma numerica


    // Lista mutable para Int
    val divisible = mutableListOf<Int>()

    for(i in 0..100){
        if(i % 7 == 0) {
            divisible.add(i)
        }
    }
    println(divisible)
}