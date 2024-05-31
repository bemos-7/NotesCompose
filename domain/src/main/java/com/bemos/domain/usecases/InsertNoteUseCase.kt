package com.bemos.domain.usecases

import com.bemos.data.database.entity.NoteModel
import com.bemos.domain.repository.NoteRepository

class InsertNoteUseCase(
    private val repository: NoteRepository
) {

    suspend fun execute(note: com.bemos.data.database.entity.NoteModel) {

        val title = note.title
        val description = note.description

        if (title.isNotEmpty() && description.isNotEmpty()) {
            repository.insert(note)
        }
    }

}