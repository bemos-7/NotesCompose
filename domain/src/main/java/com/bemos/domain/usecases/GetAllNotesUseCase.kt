package com.bemos.domain.usecases

import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(
    private val repository: NoteRepository
) {

    fun execute() : Flow<List<Note>> {
        return repository.getAllNotes()
    }

}