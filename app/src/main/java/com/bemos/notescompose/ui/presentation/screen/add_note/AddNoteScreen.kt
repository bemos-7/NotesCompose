package com.bemos.notescompose.ui.presentation.screen.add_note

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.AddNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory.AddNoteViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel

@Composable
fun AddNoteScreen(
    navController: NavController
) {
    val context = LocalContext.current

    val viewModel = viewModel<AddNoteViewModel>(
        factory = AddNoteViewModelFactory(context)
    )
    
    AddNoteContent(
        onClick = { note ->
            viewModel.insertNote(note)

            navController.navigate("notes")
        }
    )
}