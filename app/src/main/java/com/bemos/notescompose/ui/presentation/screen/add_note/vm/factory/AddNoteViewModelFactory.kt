package com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.usecases.InsertNoteUseCase
import com.bemos.domain.usecases.UpdateNoteUseCase
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.AddNoteViewModel

class AddNoteViewModelFactory(
    val insertNoteUseCase: InsertNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNoteViewModel(
            insertNoteUseCase = insertNoteUseCase,
            updateNoteUseCase = updateNoteUseCase
        ) as T
    }

}