
fun main () {

    val numero = 7609
    val resultado = nextBig(numero)
    println(resultado)

}

fun nextBig(input: Int) : Int {

    // Convierte el número a cadena, luego cada carácter a dígito, y lo almacena en un IntArray
    val arreglo = input.toString().map { it.digitToInt() }.toIntArray()

    // Ordenar el array
    val ordenado = arreglo.sortedDescending()

    // Si el numero ordenado descendente es igual a los digitos ingresados
    if (ordenado == arreglo.toList()) {
        return -1 // Es el mayor posible
    }
    // Convertir a string
    val digitos = ordenado.joinToString("")

    // Convertir a numero
    val numero = digitos.toInt()

    return numero
}

