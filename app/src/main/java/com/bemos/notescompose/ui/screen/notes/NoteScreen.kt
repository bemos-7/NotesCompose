package com.bemos.notescompose.ui.screen.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.screen.notes.vm.NoteViewModelFactory
import com.bemos.notescompose.ui.screen.notes.vm.NotesViewModel

@Composable
fun NoteScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel = viewModel<NotesViewModel>(
        factory = NoteViewModelFactory(context)
    )

    val notes by viewModel.allNote.collectAsState()
    
    NotesContent(
        listNote = notes,
        onClick = {
            navController.navigate("addNote")
        }
    )
}