package com.bemos.notescompose.ui.presentation.screen.notes

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.lazy.layout.getDefaultLazyLayoutKey
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.domain.model.Note
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.AddNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.NotesViewModel
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    navController: NavController,
    viewModelItem: NoteDetailsItemViewModel = viewModel(),
    viewModelNote: AddNoteViewModel = viewModel()
) {

    val context = LocalContext.current

    val viewModel = viewModel<NotesViewModel>(
        factory = NotesViewModelFactory(context)
    )

    viewModel.getAllNotes()

    val noteState by viewModel.allNote.collectAsState()

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

    val updateNote = remember {
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
            title = { Text(text = "Выберите действие") },
            confirmButton = {
                TextButton(onClick = {
                        openAlertDialog.value = false

                        viewModel.deleteNote(deleteNote.value)
                    }
                ) {
                    Text(text = "Удалить")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openAlertDialog.value = false

                        viewModelNote.updateNoteItem(updateNote.value)
                        navController.navigate("addNote")
                    }
                ) {
                    Text(text = "Изменить")
                }
            }
        )
    }

    NotesContent(
        listNote = noteState,
        onClick = {
            navController.navigate("addNote")
        },
        onClickItem = {
            viewModelItem.updateId(it)
            Log.d("NoteItem", viewModelItem.itemId.value.toString())
            navController.navigate("noteDetails")
        },
        onLongClickItem = {
            openAlertDialog.value = true
            deleteNote.value = it
            updateNote.value = it
            Log.d("itemSaveTest", updateNote.value.title)
        }
    )
}