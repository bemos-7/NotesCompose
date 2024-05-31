package com.bemos.data.database.repository

import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.model.toDomain
import com.bemos.data.database.model.toEntity
import com.bemos.domain.model.Note
import com.bemos.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
            .map { entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun insert(note: Note) {
        return noteDao.insert(note.toEntity())
    }

}