package com.bemos.domain.repository

import com.bemos.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes() : Flow<List<Note>>

    fun getNoteById(noteId: Int) : Flow<Note>

    suspend fun insert(note: Note)

    suspend fun delete(note: Note)

    suspend fun updateNoteTitle(id: Int, newTitle: String)

    suspend fun updateNoteDescription(id: Int, newDescription: String)

}