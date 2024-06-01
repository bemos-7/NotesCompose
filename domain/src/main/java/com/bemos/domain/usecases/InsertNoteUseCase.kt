package com.bemos.domain.usecases

import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository

class InsertNoteUseCase(
    private val repository: NoteRepository
) {

    suspend fun execute(note: Note) {

        val title = note.title
        val description = note.description

        if (title.isNotEmpty() && description.isNotEmpty()) {
            repository.insert(note)
        }
    }

}