import java.util.Scanner

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
        val userInputNoteName = readNonEmptyInput(scanner, "Введите имя заметки!", "Вы не ввели имя заметки, пожалуйста, введите имя заметки!")
        val userInputNoteContent = readNonEmptyInput(scanner, "Введите содержание заметки!", "Вы не ввели содержание заметки, пожалуйста, введите содержание заметки!")

        val note = Note(userInputNoteName, userInputNoteContent)
        archive.notes.add(note)
        items.add(MenuItem(userInputNoteName, action = { showNote(note) }))
    }

    fun showNote(note: Note) {
        val menu = Menu(note.content, mutableListOf(), scanner)
        menu.start()
    }
}