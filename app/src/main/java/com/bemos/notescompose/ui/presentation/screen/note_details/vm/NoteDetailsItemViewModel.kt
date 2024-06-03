package com.bemos.notescompose.ui.presentation.screen.note_details.vm

import androidx.lifecycle.ViewModel
import com.bemos.domain.usecases.UpdateItemIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NoteDetailsItemViewModel(
    private val updateItemIdUseCase: UpdateItemIdUseCase
) : ViewModel() {

    val itemId = MutableStateFlow(0)

    // FIXME:
    // make the useCase
    fun updateId(id: Int) {
        val newId = updateItemIdUseCase.execute(id)
        itemId.update {
            newId
        }
    }
}