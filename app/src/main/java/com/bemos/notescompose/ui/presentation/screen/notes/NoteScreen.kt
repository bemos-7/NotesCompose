package com.bemos.notescompose.ui.presentation.screen.notes

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.data.database.entity.NoteModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory

@Composable
fun NoteScreen(
    navController: NavController
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
        }
    )

}