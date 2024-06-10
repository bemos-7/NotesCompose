package com.bemos.notescompose.ui.presentation.screen.notes

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.domain.model.Note
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.IntentNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory

@Composable
fun NoteScreen(
    navController: NavController,
    viewModelItem: NoteDetailsItemViewModel = viewModel(),
    intentNoteViewModel: IntentNoteViewModel = viewModel(),
    notesViewModel: NotesViewModel
) {

    notesViewModel.getAllNotes()

    val noteState by notesViewModel.allNote.collectAsState()

    val openAlertDialog = remember {
        mutableStateOf(false)
    }

    val deleteNote = remember {
        mutableStateOf(
            Note(
                title = "",
                description = ""
            )
        )
    }

    val updateNoteId = remember {
        mutableIntStateOf(-1)
    }

    val updateNoteItem = remember {
        mutableStateOf(
            Note(
                title = "",
                description = ""
            )
        )
    }

    // FIXME:
    // viewModel
    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { openAlertDialog.value = false },
            title = { Text(text = "Подтверждения действия") },
            text = { Text(text = "Вы действительно хотите удалить выбранный элемент") },
            confirmButton = {
                TextButton(onClick = {
                        openAlertDialog.value = false
                        notesViewModel.deleteNote(deleteNote.value)
                    }
                ) {
                    Text(text = "Удалить")
                }
            }
        )
    }

    NotesContent(
        listNote = noteState,
        onClick = {
            navController.navigate("addNote")
        },
        onClickItem = { id, note ->
            viewModelItem.updateId(id)
            updateNoteId.value = id
            updateNoteItem.value = note
            intentNoteViewModel.updateNoteId(updateNoteId.value)
            intentNoteViewModel.updateNoteItem(updateNoteItem.value)
            navController.navigate("addNote")
        },
        onLongClickItem = { note ->
            openAlertDialog.value = true
            deleteNote.value = note
        }
    )
}