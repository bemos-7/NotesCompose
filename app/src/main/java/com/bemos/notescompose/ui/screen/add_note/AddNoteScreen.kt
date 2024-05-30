package com.bemos.notescompose.ui.screen.add_note

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.screen.notes.vm.NoteViewModelFactory
import com.bemos.notescompose.ui.screen.notes.vm.NotesViewModel

@Composable
fun AddNoteScreen(
    navController: NavController
) {
    val context = LocalContext.current

    val viewModel = viewModel<NotesViewModel>(
        factory = NoteViewModelFactory(context)
    )
    
    AddNoteContent(
        onClick = { note ->
            viewModel.insertNote(note)

            navController.popBackStack()
        }
    )
}