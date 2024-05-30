package com.bemos.notescompose.ui.database.repository

import androidx.lifecycle.LiveData
import com.bemos.notescompose.ui.database.dao.NoteDao
import com.bemos.notescompose.ui.database.entity.NoteModel

interface NoteRepository {

    fun getAllNotes() : LiveData<List<NoteModel>>

    fun insert(note: NoteModel)

}