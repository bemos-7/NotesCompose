package com.bemos.notescompose.ui.database.repository

import androidx.lifecycle.LiveData
import com.bemos.notescompose.ui.database.dao.NoteDao
import com.bemos.notescompose.ui.database.entity.NoteModel

class NoteRepo(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): LiveData<List<NoteModel>> {
        return noteDao.getAllNotes()
    }

    override fun insert(note: NoteModel) {
        return noteDao.insert(note)
    }

}