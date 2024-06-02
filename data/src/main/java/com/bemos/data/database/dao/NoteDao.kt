package com.bemos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bemos.data.database.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNoteById(noteId: Int) : Flow<NoteEntity>

    @Insert
    suspend fun insert(note: NoteEntity)

}