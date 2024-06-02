package com.bemos.notescompose.ui.presentation.screen.note_details.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NoteDetailsItemViewModel : ViewModel() {

    val itemId = MutableStateFlow(0)

    // FIXME:
    // make the useCase
    fun updateId(id: Int) {
        itemId.update {
            id
        }
    }
}