package com.bemos.notescompose.ui.presentation.screen.note_details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.factory.NoteDetailsViewModelFactory

@Composable
fun NoteDetailsScreen(
    navController: NavController,
    viewModelItem: NoteDetailsItemViewModel = viewModel()
) {

    val context = LocalContext.current

    val viewModel = viewModel<NoteDetailsViewModel>(
        factory = NoteDetailsViewModelFactory(context = context)
    )

    val itemId by viewModelItem.itemId.collectAsState()

    viewModel.getNoteById(itemId)

    Log.d("NoteItem", itemId.toString())

    val note by viewModel.note.collectAsState()

    NoteDetailsContent(
        note = note
    )

}