package com.bemos.notescompose.ui.presentation.screen.add_note.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Note
import com.bemos.domain.usecases.UpdateNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val insertNoteUseCase: com.bemos.domain.usecases.InsertNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNoteUseCase.execute(note)
        }
    }

    fun updateNoteTitle(id: Int, newTitle: String) {
        viewModelScope.launch {
            updateNoteUseCase.executeUpdateTitle(id, newTitle)
        }
    }

    fun updateNoteDescription(id: Int, newDescription: String) {
        viewModelScope.launch {
            updateNoteUseCase.executeUpdateDesc(id, newDescription)
        }
    }

}