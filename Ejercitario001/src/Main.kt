//
// Ejercitario 001
// Realizado por Sofia Sanabria

fun main() {

    /** Ejercicio 1: Declara dos variables numéricas (con el valor que desees), muestra por consola la suma, resta, multiplicación, división y módulo (resto de la división). */

    val numero1 = 22
    val numero2 = 15

    val suma = numero1 + numero2
    println("$numero1 + $numero2 = $suma")
    val resta = numero1 - numero2
    println("$numero1 - $numero2 = $resta")
    val multiplicacion = numero1 * numero2
    println("$numero1 * $numero2 = $multiplicacion")
    val divicion = numero1 / numero2
    println("$numero1 / $numero2 = $divicion")
    val modulo = numero2 % numero1
    println("$numero1 % $numero2 = $modulo")
    println()

    /** Ejercicio 2: Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos. Si son iguales indicarlo también. Ve cambiando los valores para comprobar que funciona. */

    println(if (numero1 > numero2) "$numero1 es mayor que $numero2" else if (numero1 < numero2) "$numero1 es menor que $numero2" else "$numero1 y $numero2 son iguales")
    println()

    /** Ejercicio 3: Declara  un  String  que  contenga  tu  nombre, después muestra un mensaje de bienvenida por consola. Por ejemplo: si introduzco “Fernando”, me aparece “Bienvenido Fernando”. */

    println("Ingrese su nombre")
    println("Bienvenida " + readLine())
    println()

    /** Ejercicio 5: Lee  un  número  por  teclado  e  indica  si  es  divisible  entre  2  (resto = 0). Si no lo es, también debemos indicarlo. */

    println("Ingrese un numero: ")

    println(if (readLine()?.toIntOrNull()?.rem(2) == 0) "Es divisible entre 2" else "No es divisible entre 2")
    println() // salto de linea

    /** Ejercicio 6: Lee un número por teclado que pida el precio de un producto (puede tener decimales) y calcule el precio final con IVA. El IVA será una constante que será del 10% */

    println("Ingrese el precio del producto:")
    val IVA = 0.10  // 10% de IVA
    val precio = readLine()?.toDoubleOrNull()

    if (precio != null) {
        val precioFinal = precio + (precio * IVA)
        println("El precio final con IVA es: $precioFinal")
    } else {
        println("Entrada invalida")
    }
    println()

    /** Ejercicio 7: Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3. */

    for (i in 1..100) if (i % 2 == 0 || i % 3 == 0) print("$i ")
    println()

    /** Ejercicio 8: Lee un número por teclado y comprueba que este número es mayor o igual que cero, si no lo es lo volverá a pedir (do while), después muestra ese número por consola. */

    var numero: Int? = null

    println("Ingrese un valor: ")

    do {
        val valor = readLine()?.toIntOrNull()
        if (valor != null && valor >= 0) {
            numero = valor
        } else {
            println("Ingrese un numero valido mayor o igual a O: ")
        }
    } while (numero == null)
    println()

    /** Ejercicio 9: Escribe una aplicación con un String que contenga una contraseña cualquiera. Después se te pedirá  que  introduzcas  la  contraseña,  con  3  intentos.  Cuando  aciertes  ya  no  pedirá  más  la contraseña y mostrará un mensaje diciendo “Correcto!”. Piensa bien en la condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).  */

    val password = "SofiGould"
    var intento = 0
    var exito = false

    while (intento < 3) {
        println("Ingresa una contraseña: ")
        val input = readLine()
        if (input != null) {
            if (input == password) {
                println("Correcto!")
                exito = true
                break
            } else {
                println("Contraseña incorrecta")
            }
        } else {
            println("Entrada invalida")
        }
        intento += 1
    }
    if (!exito) {
        println("Fallaste jaja!!")
    }
    println()

    /** Ejercicio10: Crea una aplicación que nos pida un día de la semana y que nos diga si es un día laboral o no (“De lunes a viernes consideramos días laborales”) */

    var input: String?
    do {
        print("Ingresa un día de la semana: ")
        input = readLine()?.lowercase() // Maneja string con mayusculas

        when (input) {
            "lunes", "martes", "miercoles", "jueves", "viernes" -> {
                println("$input es un día laboral")
            }

            "sabado", "domingo" -> {
                println("$input es fin de semana.")
            }

            else -> {
                println("Entrada inválida. Ingresa un día válido.")
                input = null  // Fuerza que se repita el ciclo
            }
        }
    } while (input == null)

}
