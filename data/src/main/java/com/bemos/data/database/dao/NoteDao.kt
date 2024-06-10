package com.bemos.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.ProvidedTypeConverter
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

    @Delete
    suspend fun delete(note: NoteEntity)

    @Query("UPDATE notes SET title = :newTitle WHERE id = :id")
    suspend fun updateNoteTitle(id: Int, newTitle: String)

    @Query("UPDATE notes SET description = :newDescription WHERE id = :id")
    suspend fun updateNoteDescription(id: Int, newDescription: String)

}