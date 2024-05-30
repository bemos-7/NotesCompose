package com.bemos.notescompose.ui.screen.notes.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.notescompose.ui.database.model.NoteEntity
import com.bemos.notescompose.ui.database.repository.NoteRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repository: NoteRepo,
): ViewModel() {

    val allNote: MutableStateFlow<List<NoteEntity>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch {
            repository.getAllNotes()
                .collect { notes ->
                    allNote.update {
                        notes
                    }
                }
        }
    }

    fun insertNote(note: NoteEntity) = viewModelScope.launch {
        repository.insert(note)
    }

}