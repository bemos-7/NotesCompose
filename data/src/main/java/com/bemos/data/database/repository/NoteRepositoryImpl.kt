package com.bemos.data.database.repository

import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.model.NoteEntity
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
            .map { entityList ->
                entityList.map { entity ->
                    entity.toDomain()
                }
            }

    }

    override fun getNoteById(noteId: Int): Flow<Note> {
        return noteDao.getNoteById(noteId).map {
            it.toDomain()
        }
    }

    override suspend fun insert(note: Note) {
        return noteDao.insert(note.toEntity())
    }

    override suspend fun delete(note: Note) {
        return noteDao.delete(note.toEntity())
    }

    override suspend fun update(note: Note) {
        return noteDao.update(note.toEntity())
    }

//    private fun mapToDomain(noteEntity: NoteEntity) : Note {
//        return Note(
//            noteEntity.id,
//            noteEntity.title,
//            noteEntity.description
//        )
//    }
//
//    private fun mapToEntity(note: Note) : NoteEntity {
//        return NoteEntity(
//            note.id,
//            note.title,
//            note.description
//        )
//    }

}