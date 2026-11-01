import java.util.Scanner
import kotlin.io.println

class NoteMenu(val archive: Archive, val scanner: Scanner ) {
    val items: MutableList<MenuItem> = ArrayList()

    fun start() {
        items.add(MenuItem("Создать заметку", action = { creatingNote() }))

        for (note in archive.notes) {
            items.add(MenuItem(note.name, action = { showNote(note) }))
        }

        val menu = Menu("Список заметок:", items, scanner)
        menu.start()
    }

    fun creatingNote() {
        var userInputNoteName = ""
        var userInputNoteContent = ""

        while (true) {
            println("Введите имя заметки!")
            userInputNoteName = scanner.nextLine()

            if (userInputNoteName.isBlank()) {
                println("Вы не ввели имя заметки, пожалуйста, введите имя заметки!")
            } else  {
                break
            }
        }
        while (true) {
            println("Введите содержание заметки!")
            userInputNoteContent = scanner.nextLine()

            if (userInputNoteContent.isBlank()) {
                println("Вы не ввели содержание заметки, пожалуйста, введите содержание заметки!")
            } else  {
                break
            }
        }

        val note = Note(userInputNoteName, userInputNoteContent)
        archive.notes.add(note)
        items.add(MenuItem(userInputNoteName, action = { showNote(note) }))
        return
    }

    fun showNote(note: Note) {
        val menu = Menu(note.content, mutableListOf(), scanner)
        menu.start()
    }
}