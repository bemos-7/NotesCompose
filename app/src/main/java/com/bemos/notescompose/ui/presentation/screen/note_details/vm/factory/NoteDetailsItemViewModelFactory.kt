package com.bemos.notescompose.ui.presentation.screen.note_details.vm.factory

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.usecases.UpdateItemIdUseCase
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel

class NoteDetailsItemViewModelFactory : ViewModelProvider.Factory {

    private val updateItemIdUseCase by lazy {
        UpdateItemIdUseCase()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteDetailsItemViewModel(
            updateItemIdUseCase
        ) as T
    }

}