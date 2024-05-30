package com.bemos.notescompose.ui.screen.notes.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.notescompose.ui.database.repository.NoteRepo
import com.bemos.notescompose.ui.database.room.NoteDatabase

class NoteViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory {

    private val database by lazy {
        NoteDatabase.getDb(context)
    }
    private val dao by lazy {
        database.getDao()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repo = NoteRepo(dao)
        return NotesViewModel(
            repository = repo
        ) as T
    }
}