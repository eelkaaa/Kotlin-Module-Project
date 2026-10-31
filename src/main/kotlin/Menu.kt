import java.util.Scanner

class Menu(val headingMenu: String, val items: MutableList<MenuItem>, val scanner: Scanner) {
    fun menu() {
        println("$headingMenu:")
        for ((menuNumber, item) in items.withIndex()) {
            println("$menuNumber. ${item.name}")
        }
        println("${items.size}. Выход")
    }

    fun inputValidation(menuNumber: String): Boolean {

        val number = menuNumber.toIntOrNull()

        return when(number) {
            null -> {
                println("Вы ввели не цифру, пожалуйста, введите цифру!")
                true
            }
            in 0..items.size - 1 -> {
                val item = items[number]
                item.action()
                true
            }
            items.size -> false
            else -> {
                println("К сожалению такой цифры в меню нет, пожалуйста, введите другую цифру!")
                true
            }
        }
    }

    fun start() {
        while (true) {
            menu()

            if(!inputValidation(scanner.nextLine())) return
        }
    }
}