package com.bemos.notescompose.ui.presentation.screen.add_note.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.data.database.model.toDomain
import com.bemos.domain.model.Note
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val insertNoteUseCase: com.bemos.domain.usecases.InsertNoteUseCase
) : ViewModel() {

    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNoteUseCase.execute(note)
        }
    }

}