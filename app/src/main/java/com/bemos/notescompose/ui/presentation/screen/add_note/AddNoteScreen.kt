package com.bemos.notescompose.ui.presentation.screen.add_note

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.AddNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.IntentNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory.AddNoteViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel

@Composable
fun AddNoteScreen(
    navController: NavController,
    intentNoteViewModel: IntentNoteViewModel = viewModel()
) {
    val context = LocalContext.current

    val viewModel = viewModel<AddNoteViewModel>(
        factory = AddNoteViewModelFactory(context)
    )

    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }

    val noteBool = remember {
        mutableStateOf(false)
    }

    val noteId = intentNoteViewModel.noteId.collectAsState()
    val noteItem = intentNoteViewModel.noteItem.collectAsState()

    if (noteItem.value.title.isNotEmpty() && noteItem.value.description.isNotEmpty()) {
        if (noteId.value >= 0) {
            title.value = noteItem.value.title
            description.value = noteItem.value.description
            noteBool.value = true
        }
    }

    isDebugInspectorInfoEnabled

    AddNoteContent(
        onClick = { note ->
            if (noteBool.value) {

                Log.d("noteBollTrue", note.title)
                Log.d("noteBollTrue", noteId.value.toString())
                viewModel.updateNoteTitle(noteId.value, note.title)
                viewModel.updateNoteDescription(noteId.value, note.description)
            } else {
                viewModel.insertNote(note)
            }
            navController.navigate("notes")
        },
        backOnClick = {
            navController.navigate("notes")
        },
        titleU = title.value,
        descriptionU = description.value
    )
}