import java.util.Scanner

class ArchiveMenu {
    val mutableArchivesList: MutableList<Archive> = ArrayList()
    val input = Scanner(System.`in`)

    fun start() {
        while (true) {
            menu()

            val userInput = input.nextLine()

            if(!inputValidation(userInput)) return
        }
    }

    fun menu() {
        println("Список архивов:")
        println("0. Создать архив")

        var archiveNumber = 1

        for (archive in mutableArchivesList) {
            println("$archiveNumber. ${archive.name}")
            archiveNumber++
        }

        println("${mutableArchivesList.size + 1}. Выход")
    }

    fun creatingArchive() {
        while (true) {
            println("Введите имя архива!")

            val userInput = input.nextLine()

            if (userInput.isBlank()) {
                println("Вы ничего не ввели, пожалуйста, введите имя!")
            } else {
                mutableArchivesList.add(Archive(userInput))
                return
            }
        }
    }

    fun inputValidation(menuNumber: String): Boolean{
        return when(menuNumber.toIntOrNull()) {
            null -> {
                println("Вы ввели не цифру, пожалуйста, введите цифру!")
                true
            }
            0 -> {
                creatingArchive()
                true
            }
            mutableArchivesList.size + 1 -> false
            else -> {
                println("К сожалению такой цифры в меню нет, пожалуйста, введите другую цифру!")
                true
            }
        }
    }
}