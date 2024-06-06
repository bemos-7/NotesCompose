package com.bemos.notescompose.ui.presentation.screen.notes.vm

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Note
import com.bemos.domain.usecases.DeleteNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getAllNotesUseCase: com.bemos.domain.usecases.GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): ViewModel() {

    val allNote: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.execute()
                .collect { note ->
                    allNote.update {
                        note
                    }
                }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase.execute(note)
        }
    }
}