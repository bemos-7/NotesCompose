package com.bemos.notescompose.ui.presentation.screen.note_details.vm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.data.database.db.NoteDatabase
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.usecases.GetNoteByIdUseCase
import com.bemos.domain.usecases.UpdateItemIdUseCase
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsViewModel

class NoteDetailsViewModelFactory(
    context: Context
) : ViewModelProvider.Factory {

    private val database by lazy {
        NoteDatabase.getDb(context)
    }

    private val repository by lazy {
        NoteRepositoryImpl(database.getDao())
    }

    private val getNoteByIdUseCase by lazy {
        GetNoteByIdUseCase(repository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteDetailsViewModel(
            getNoteByIdUseCase = getNoteByIdUseCase
        ) as T
    }

}