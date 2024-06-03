package com.bemos.notescompose.ui.presentation.screen.add_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.domain.model.Note
import com.bemos.notescompose.ui.theme.NotesComposeTheme

@Composable
fun AddNoteContent(
    onClick: (Note) -> Unit
) {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            Modifier
                .width(350.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 15.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var title by remember {
                mutableStateOf("")
            }

            var description by remember {
                mutableStateOf("")
            }

            TextField(
                value = title,
                onValueChange = {title = it},
                placeholder = { Text(text = "Title") }
            )

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                value = description,
                onValueChange = {description = it},
                placeholder = { Text(text = "Description") }
            )

            var note by remember {
                mutableStateOf(
                    Note(
                        title = "",
                        description = ""
                    )
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = {
                    val noteItem = Note(
                        title = title,
                        description = description
                    )

                    note = noteItem

                    onClick(note)
                },
            ) {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddNoteContentPreview() {
    NotesComposeTheme {
        AddNoteContent(onClick = {

        })
    }
}