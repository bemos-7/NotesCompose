package com.bemos.notescompose.ui.database.repository

import com.bemos.notescompose.ui.database.model.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes() : Flow<List<NoteEntity>>

    suspend fun insert(note: NoteEntity)

}