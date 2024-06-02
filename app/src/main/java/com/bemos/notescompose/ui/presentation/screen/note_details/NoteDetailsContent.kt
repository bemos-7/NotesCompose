package com.bemos.notescompose.ui.presentation.screen.note_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.domain.model.Note
import com.bemos.notescompose.ui.theme.NotesComposeTheme

@Composable
fun NoteDetailsContent(
    note: Note
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = note.title)

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = note.description)
    }
}

@Preview(showBackground = true)
@Composable
fun NoteDetailsContentPreview() {
    NotesComposeTheme {
        NoteDetailsContent(
            note = Note(
                title = "tesla",
                description = "tesla"
            )
        )
    }
}