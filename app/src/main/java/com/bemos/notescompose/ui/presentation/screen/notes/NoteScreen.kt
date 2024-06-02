package com.bemos.notescompose.ui.presentation.screen.notes

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory

@Composable
fun NoteScreen(
    navController: NavController,
    viewModelItem: NoteDetailsItemViewModel = viewModel()
) {

    val context = LocalContext.current

    val viewModel = viewModel<NotesViewModel>(
        factory = NotesViewModelFactory(context)
    )

    viewModel.getAllNotes()

    val noteState by viewModel.allNote.collectAsState()
    
    NotesContent(
        listNote = noteState,
        onClick = {
            navController.navigate("addNote")
        },
        onClickItem = {
            viewModelItem.updateId(it)
            Log.d("NoteItem", viewModelItem.itemId.value.toString())
            navController.navigate("noteDetails")
        }
    )

}