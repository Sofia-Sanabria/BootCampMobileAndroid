package book

open class Book (var tittle: String, val autor: String) {
    private var currentPage = 0

    open fun readPage() {
        currentPage += 1
    }
}

class eBook (tittle: String, autor: String, val format: String = "text") : Book(tittle, autor) {
    var wordCount = 0

    override fun readPage() {
        wordCount += 250
    }
}

fun main() {
    val physicalBook = Book("1984", "George Orwell")
    val digitalBook = eBook("Digital Fortress", "Dan Brown")

    physicalBook.readPage()
    digitalBook.readPage()
    digitalBook.readPage()

    // No se puede acceder a currentPage desde fuera (es privado)
    // println(physicalBook.currentPage)

    println("eBook words read: ${digitalBook.wordCount}") // 500
}
