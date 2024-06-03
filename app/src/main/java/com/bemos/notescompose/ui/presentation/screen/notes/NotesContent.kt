package com.bemos.notescompose.ui.presentation.screen.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.domain.model.Note
import com.bemos.notescompose.R
import com.bemos.notescompose.ui.presentation.screen.notes.adapter.NoteItem

@Composable
fun NotesContent(
    listNote: List<Note>,
    onClick: () -> Unit,
    onClickItem: (Int) -> Unit,
    onLongClickItem: (Note) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            Modifier.fillMaxWidth()
        ) {
            items(items = listNote) {
                NoteItem(item = it, onClickItem, onLongClickItem)
            }
            item {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(50.dp)
                        .clickable {
                            onClick()
                        }
                        .align(Alignment.CenterHorizontally),

                    tint = MaterialTheme.colorScheme.primary,
                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                    contentDescription = "plus",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesContentPreview() {

    val list: List<Note> = listOf(
        Note(
            title = "sdfs",
            description = "sldkf"
        ),
        Note(
            title = "sdfs",
            description = "sldkf"
        ),
        Note(
            title = "sdfs",
            description = "sdflg"
        ),
    )

    NotesContent(
        list,
        onClick = {},
        onClickItem = {},
        onLongClickItem = {}
    )
}