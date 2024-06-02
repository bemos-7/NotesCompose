package com.bemos.domain.usecases

import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {

    fun execute(id: Int) : Flow<Note> {
        return repository.getNoteById(id)
    }

}