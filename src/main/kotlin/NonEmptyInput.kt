import java.util.Scanner

fun readNonEmptyInput(scanner: Scanner, question: String, error: String): String {
    while (true) {
        println(question)

        val userInput = scanner.nextLine()

        if (userInput.isBlank()) {
            println(error)
        } else  {
            return userInput
        }
    }
}