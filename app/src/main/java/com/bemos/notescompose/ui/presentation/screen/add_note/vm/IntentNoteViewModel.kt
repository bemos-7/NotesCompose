package com.bemos.notescompose.ui.presentation.screen.add_note.vm

import androidx.lifecycle.ViewModel
import com.bemos.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow

class IntentNoteViewModel : ViewModel() {

    val noteId = MutableStateFlow(-1)

    val noteItem = MutableStateFlow(
        Note(
            title = "",
            description = ""
        )
    )

    fun updateNoteId(id: Int) {
        noteId.value = id
    }

    fun updateNoteItem(note: Note) {
        noteItem.value = note
    }

}