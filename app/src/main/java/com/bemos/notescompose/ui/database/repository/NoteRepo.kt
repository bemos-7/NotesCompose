package com.bemos.notescompose.ui.database.repository

import com.bemos.notescompose.ui.database.room.NoteDao
import com.bemos.notescompose.ui.database.model.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepo(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    override suspend fun insert(note: NoteEntity) {
        return noteDao.insert(note)
    }

}