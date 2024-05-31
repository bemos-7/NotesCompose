package com.bemos.notescompose.ui.presentation.screen.notes.vm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.data.database.db.NoteDatabase
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.usecases.GetAllNotesUseCase
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel

class NotesViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory {

    private val database by lazy {
        com.bemos.data.database.db.NoteDatabase.getDb(context)
    }

    private val repository by lazy {
        com.bemos.data.database.repository.NoteRepositoryImpl(database.getDao())
    }

    private val getAllNoteUseCase by lazy {
        com.bemos.domain.usecases.GetAllNotesUseCase(repository)
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(
            getAllNotesUseCase =  getAllNoteUseCase
        ) as T
    }

}