package com.bemos.domain.usecases

import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend fun execute(note: Note) {
        repository.delete(note)
    }

}