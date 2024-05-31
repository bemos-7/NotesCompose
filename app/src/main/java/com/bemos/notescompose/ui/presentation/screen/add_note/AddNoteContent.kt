package com.bemos.notescompose.ui.presentation.screen.add_note

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
fun AddNoteContent(
    onClick: (Note) -> Unit
) {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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

        //FIXME:
        // 1. Тут нужно использовать remember
        // 2. Можно было создавать note только при нажатии на кнопку
        val note = Note(
            title = title,
            description = description
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                onClick(note)
            },
            ) {
            Text(
                text = "Submit"
            )
        }
    }
}

@Preview
@Composable
fun AddNoteContentPreview() {
    NotesComposeTheme {
        AddNoteContent(onClick = {

        })
    }
}