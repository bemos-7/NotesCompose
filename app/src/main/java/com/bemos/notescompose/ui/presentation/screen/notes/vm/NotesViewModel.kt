package com.bemos.notescompose.ui.presentation.screen.notes.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.data.database.entity.NoteModel
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.usecases.GetAllNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getAllNotesUseCase: com.bemos.domain.usecases.GetAllNotesUseCase
): ViewModel() {

    val allNote: MutableStateFlow<List<com.bemos.data.database.entity.NoteModel>> = MutableStateFlow(emptyList())

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

}