import java.util.Scanner

class ArchiveMenu {
    val mutableArchivesList: MutableList<Archive> = ArrayList()
    val items: MutableList<MenuItem> = ArrayList()
    val input = Scanner(System.`in`)

    fun start() {
        items.add(MenuItem("Создать архив", action = { creatingArchive() }))
        val menu = Menu("Список архивов:", items, input)
        menu.start()
    }

    fun creatingArchive() {
        while (true) {
            println("Введите имя архива!")
            val userInput = input.nextLine()

            //Про метод isBlank() подсказала Алиса :), чтобы не писать userInput.trim().isEmpty()
            if (userInput.isBlank()) {
                println("Вы ничего не ввели, пожалуйста, введите имя архива!")
            } else {
                val archive = Archive(userInput)
                mutableArchivesList.add(archive)
                items.add(MenuItem(userInput, action = {
                    val note = NoteMenu(archive, input)
                    note.start()
                }))
                return
            }
        }
    }
}