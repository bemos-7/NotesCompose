package com.bemos.notescompose.ui.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bemos.notescompose.ui.presentation.screen.add_note.AddNoteScreen
import com.bemos.notescompose.ui.presentation.screen.note_details.NoteDetailsScreen
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.NoteDetailsItemViewModel
import com.bemos.notescompose.ui.presentation.screen.note_details.vm.factory.NoteDetailsItemViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.notes.NoteScreen
import com.bemos.notescompose.ui.theme.NotesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val viewModelItem = viewModel<NoteDetailsItemViewModel>(
                factory = NoteDetailsItemViewModelFactory()
            )

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

                            )
                        }
                        
                        composable(
                            route = "addNote"
                        ) {
                            AddNoteScreen(navController = navController)
                        }

                        composable(
                            route = "noteDetails",
                            enterTransition = {
                                slideInHorizontally(
                                    initialOffsetX = { it },
                                    animationSpec = tween(
                                        durationMillis = 500,
                                        easing = LinearOutSlowInEasing
                                    ),
                                )
                            },
                            exitTransition = {
                                slideOutHorizontally(
                                    targetOffsetX = { it },
                                    animationSpec = tween(
                                        durationMillis = 500,
                                        easing = LinearOutSlowInEasing,
                                    )
                                )
                            }
                        ) {
                            NoteDetailsScreen(
                                navController = navController,
                                viewModelItem = viewModelItem
                            )
                        }
                    }
                }
            }
        }
    }
}