package com.bemos.data.database.repository

import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.entity.NoteModel
import com.bemos.notescompose.ui.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<NoteModel>> {
        return noteDao.getAllNotes()
    }

    override suspend fun insert(note: NoteModel) {
        return noteDao.insert(note)
    }

}