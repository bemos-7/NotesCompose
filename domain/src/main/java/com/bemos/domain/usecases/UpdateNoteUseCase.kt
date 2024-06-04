package com.bemos.domain.usecases

import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {

    suspend fun update(note: Note) {
        repository.update(note)
    }

}