package com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.data.database.db.NoteDatabase
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.usecases.InsertNoteUseCase
import com.bemos.domain.usecases.UpdateNoteUseCase
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.AddNoteViewModel

class AddNoteViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    private val database by lazy {
        com.bemos.data.database.db.NoteDatabase.getDb(context)
    }

    private val repository by lazy {
        com.bemos.data.database.repository.NoteRepositoryImpl(database.getDao())
    }

    private val insertNoteUseCase by lazy {
        com.bemos.domain.usecases.InsertNoteUseCase(repository)
    }

    private val updateNoteUseCase by lazy {
        UpdateNoteUseCase(repository)
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNoteViewModel(
            insertNoteUseCase = insertNoteUseCase,
            updateNoteUseCase = updateNoteUseCase
        ) as T
    }

}