package com.bemos.domain.usecases

import com.bemos.data.database.entity.NoteModel
import com.bemos.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(
    private val repository: NoteRepository
) {

    fun execute() : Flow<List<com.bemos.data.database.entity.NoteModel>> {
        return repository.getAllNotes()
    }

}