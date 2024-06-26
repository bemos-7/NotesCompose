package com.bemos.notescompose.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bemos.notescompose.ui.di.appComponent
import com.bemos.notescompose.ui.presentation.screen.add_note.AddNoteScreen
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.IntentNoteViewModel
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory.AddNoteViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.factory.NoteDetailsItemViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.notes.NoteScreen
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory
import com.bemos.notescompose.ui.theme.NotesComposeTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var notesViewModelFactory: NotesViewModelFactory

    @Inject
    lateinit var addNoteViewModelFactory: AddNoteViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        setContent {
            val navController = rememberNavController()

            val viewModelItem = viewModel<NoteDetailsItemViewModel>(
                factory = NoteDetailsItemViewModelFactory()
            )

            val intentViewModel = viewModel<IntentNoteViewModel>()

            NotesComposeTheme {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "notes"
                    ) {
                        composable(
                            route = "notes"
                        ) {
                            NoteScreen(
                                navController = navController,
                                viewModelItem = viewModelItem,
                                intentNoteViewModel = intentViewModel,
                                notesViewModel = viewModel(
                                    factory = notesViewModelFactory
                                )
                            )
                        }
                        
                        composable(
                            route = "addNote",
                            enterTransition = {
                                slideInVertically(
                                    initialOffsetY = { it },
                                    animationSpec = tween(
                                        durationMillis = 500,
                                        easing = LinearOutSlowInEasing
                                    )
                                )
                            },
                            exitTransition = {
                                slideOutVertically(
                                    targetOffsetY = { it },
                                    animationSpec = tween(
                                        durationMillis = 500,
                                        easing = LinearOutSlowInEasing
                                    )
                                )
                            }
                        ) {
                            AddNoteScreen(
                                navController = navController,
                                intentNoteViewModel = intentViewModel,
                                viewModel = viewModel(
                                    factory = addNoteViewModelFactory
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}