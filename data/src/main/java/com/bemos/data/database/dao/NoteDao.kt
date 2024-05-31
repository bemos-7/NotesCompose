package com.bemos.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bemos.data.database.entity.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : Flow<List<NoteModel>>

    @Insert
    suspend fun insert(note: NoteModel)

}