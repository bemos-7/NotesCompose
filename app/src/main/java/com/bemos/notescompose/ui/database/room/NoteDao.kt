package com.bemos.notescompose.ui.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bemos.notescompose.ui.database.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity)

}