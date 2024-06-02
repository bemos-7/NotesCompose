package com.bemos.notescompose.ui.presentation.screen.note_details.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Note
import com.bemos.domain.usecases.GetNoteByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NoteDetailsViewModel(
    private val getNoteByIdUseCase: GetNoteByIdUseCase
) : ViewModel() {

    val note: MutableStateFlow<Note> = MutableStateFlow(Note(
        title = "",
        description = ""
    ))

    fun getNoteById(id: Int) = viewModelScope.launch {
            getNoteByIdUseCase.execute(id)
                .collect { noteItem ->
                    note.update {
                        noteItem
                    }
                }
    }

}