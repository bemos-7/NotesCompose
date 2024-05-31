package com.bemos.notescompose.ui.presentation.screen.add_note.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.data.database.entity.NoteModel
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.usecases.InsertNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val insertNoteUseCase: com.bemos.domain.usecases.InsertNoteUseCase
) : ViewModel() {

    fun insertNote(note: com.bemos.data.database.entity.NoteModel) {
        viewModelScope.launch {
            insertNoteUseCase.execute(note)
        }
    }

}