package com.bemos.notescompose.ui.screen.notes

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.database.entity.NoteModel
import com.bemos.notescompose.ui.screen.notes.vm.NotesViewModel

@Composable
fun NoteScreen(
    navController: NavController
) {

    val context = LocalContext.current

    val viewModel = viewModel<NotesViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NotesViewModel(context) as T
            }
        }
    )

    val noteState = remember {
        mutableStateOf<List<NoteModel>>(emptyList())
    }
    
//    LaunchedEffect(viewModel) {
//        viewModel.getAllNotes().observeForever {
//            noteState.value = it
//        }
//    }

    viewModel.getAllNotes().observeForever {
        noteState.value = it
    }
    
    NotesContent(
        listNote = noteState.value,
        onClick = {
            if (it) {
                navController.popBackStack()
                navController.navigate("addNote")
            }
        }
    )

}