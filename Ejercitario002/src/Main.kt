/** Ejercicio 1: Cargar un array de manera aleatoria con 10 números enteros del -5 al 5. Imprimirlo en pantalla y
computar cuál es el mayor elemento del vector. */

fun main () {
    val array = intArrayOf(10)
    val lista = array.toMutableList() // Convertir arreglo a lista

    for (i in 1..10) {
        val aleatorio = (-5..5).random() // Entre -5 y 5
        lista.add(aleatorio) // Agregar a la lista
    }
    println("Array: $lista")

    val mayor = array.maxOrNull()
    if (mayor != null) {
        println("El mayor elemento es: $mayor")
    }

    /** Ejercicio 2: Cargar  un  array  de  manera  aleatoria  con  100  números enteros del -30 al 30. Imprimirlo en pantalla y computar cuál es el elemento que más veces se repite, y cuáles son los números  que no están presentes (si es que hay alguno).  */

    var arreglo = IntArray(100) { (-30..30).random() } // Arreglo con valores aleatorios
    println("Arreglo generado:")
    println(arreglo.joinToString())

    val diccionario = mutableMapOf<Int, Int>()   // Diccionario mutable vacío

    // Contar ocurrencias de elementos
    for (a in arreglo) {
        // Obtener el valor actual (o 0 si no existe), y sumarle 1
        diccionario[a] = diccionario.getOrDefault(a, 0) + 1
    }

    // extraer el maximo numero del diccionario
    val maximo = diccionario.maxByOrNull { it.value }
    if (maximo != null) {
        // desestructurar
        val (numero, cantidad) = maximo
        println("El número que más se repite es $numero (aparece $cantidad veces)")
    }

    val ausentes = mutableListOf<Int>()
    for (i in -30..30){
        if (i !in diccionario) {
            ausentes.add(i)
        }
    }
    if (!ausentes.isEmpty()) {
        println("Elementos ausentes:")
        println(ausentes)
    }

    /** Ejercicio 3: Hacer una función que, dada una palabra (String) o frase, diga si la misma es palíndromo o  no. Una palabra/frase palíndromo es aquella que se lee igual tanto de atrás para adelante,  como de adelante  para  atrás.  Ejemplos  de  palíndromos:  "MADAM",  "RACECAR",  "AMORE,   ROMA", "BORROW OR ROB", "WAS IT A CAR OR A CAT I SAW?" */

    var palabra = "MADAM"

    val palindromo = palabra.reversed()

    if (palindromo == palabra) {
        println("La palabra $palabra es palindromo")
    } else {
        println("La palabra $palabra No es palindromo")
    }

    /** Ejercicio 4: Dada una cadena de caracteres (String) de longitud desconocida que tiene solamente dígitos,
    crear un array de N elementos (donde N es el tamaño de la cadena) que tenga cada uno de los
    valores numéricos de los dígitos. */

    val cadena = "1234567A90"
    val digitos = mutableListOf<Int>() // Lista vacia de enteros

    for (caracter in cadena) {
        val numero = caracter.toString().toIntOrNull()
        if (numero != null){
            digitos.add(numero)
        } else {
            println("Caracter no valido: $caracter")
        }
    }
    println("Array: ")
    println(digitos)
}