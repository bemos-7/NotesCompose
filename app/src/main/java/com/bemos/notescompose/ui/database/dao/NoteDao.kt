package com.bemos.notescompose.ui.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bemos.notescompose.ui.database.entity.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : LiveData<List<NoteModel>>

    @Insert
    fun insert(note: NoteModel)

}