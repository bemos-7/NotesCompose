package com.bemos.notescompose.ui.screen.notes.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bemos.notescompose.ui.database.dao.NoteDao
import com.bemos.notescompose.ui.database.db.NoteDatabase
import com.bemos.notescompose.ui.database.entity.NoteModel
import com.bemos.notescompose.ui.database.repository.NoteRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(context: Context): ViewModel() {

    private val repository: NoteRepo
    private val allNote: LiveData<List<NoteModel>>

    val scope = CoroutineScope(Dispatchers.IO)

    init {
        val dao = NoteDatabase.getDb(context).getDao()
        repository = NoteRepo(dao)
        allNote = repository.getAllNotes()
    }

    fun getAllNotes() : LiveData<List<NoteModel>> {
        return allNote
    }

    fun insertNote(note: NoteModel) {
        scope.launch {
            repository.insert(note)
        }
    }

}