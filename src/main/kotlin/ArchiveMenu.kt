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
        val archiveName = readNonEmptyInput(input, "Введите имя архива!", "Вы ничего не ввели, пожалуйста, введите имя архива!")

        val archive = Archive(archiveName)
        mutableArchivesList.add(archive)
        items.add(MenuItem(archiveName, action = {
            val note = NoteMenu(archive, input)
            note.start()
        }))
    }
}