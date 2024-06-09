package com.bemos.notescompose.ui.presentation.screen.notes.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.usecases.DeleteNoteUseCase
import com.bemos.domain.usecases.GetAllNotesUseCase
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel

class NotesViewModelFactory(
    val getAllNotesUseCase: GetAllNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(
            getAllNotesUseCase =  getAllNotesUseCase,
            deleteNoteUseCase = deleteNoteUseCase
        ) as T
    }

}