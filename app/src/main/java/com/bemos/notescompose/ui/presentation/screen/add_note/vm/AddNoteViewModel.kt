package com.bemos.notescompose.ui.presentation.screen.add_note.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Note
import com.bemos.domain.usecases.UpdateNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val insertNoteUseCase: com.bemos.domain.usecases.InsertNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    val noteItem = MutableStateFlow(
        Note(
            title = "",
            description = ""
        )
    )

    fun updateNoteItem(note: Note) {
        noteItem.value = note
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNoteUseCase.execute(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            updateNoteUseCase.update(note)
        }
    }

}