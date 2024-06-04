package com.bemos.notescompose.ui.presentation.screen.add_note

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Note
import com.bemos.notescompose.R
import com.bemos.notescompose.ui.theme.NotesComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteContent(
    onClick: (Note) -> Unit,
    backOnClick: () -> Unit,
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var note by remember {
        mutableStateOf(
            Note(
                title = "",
                description = ""
            )
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                    backOnClick()
                },
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = "back",
                tint = MaterialTheme.colorScheme.primary
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.clickable {
                        val noteItem = Note(
                            title = title,
                            description = description
                        )

                        note = noteItem

                        onClick(note)
                    },
                    text = "Готово",
                    )
            }
        }

        Column(
            Modifier
                .width(370.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 30.dp, bottom = 15.dp),

        ) {
            TextField(
                value = title,
                onValueChange = {title = it},
                textStyle = TextStyle.Default.copy(fontSize = 22.sp),
                placeholder = { Text(text = "Title", fontSize = 22.sp) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
            )

            TextField(
                value = description,
                onValueChange = {description = it},
                placeholder = { Text(text = "Description") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AddNoteContentPreview() {
    NotesComposeTheme {
        AddNoteContent(
            onClick = {},
            backOnClick = {},
        )
    }
}