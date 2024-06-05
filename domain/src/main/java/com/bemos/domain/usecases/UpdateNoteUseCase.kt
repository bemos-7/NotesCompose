package com.bemos.domain.usecases

import com.bemos.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {

    // FIXME
    // make other useCase
    suspend fun executeUpdateTitle(id: Int, newTitle: String) {
        return repository.updateNoteTitle(id, newTitle)
    }

    suspend fun executeUpdateDesc(id: Int, newDescription: String) {
        return repository.updateNoteTitle(id, newDescription)
    }

}