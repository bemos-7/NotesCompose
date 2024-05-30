package com.bemos.notescompose.ui.screen.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.notescompose.R
import com.bemos.notescompose.ui.screen.notes.adapter.NoteItem
import com.bemos.notescompose.ui.database.model.NoteEntity

@Composable
fun NotesContent(
    listNote: List<NoteEntity>,
    onClick: () -> Unit
) {
    Box {
        LazyColumn(
            Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(end = 20.dp, start = 20.dp, top = 10.dp)
        ) {
            items(items = listNote) {
                NoteItem(item = it)

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        Icon(
            modifier = Modifier
                .padding(bottom = 20.dp, end = 20.dp)
                .size(70.dp)
                .clip(CircleShape)
                .clickable {
                    onClick()
                }
                .align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.baseline_add_circle_24),
            contentDescription = "plus",
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NotesContentPreview() {

    val list: List<NoteEntity> = listOf(
            NoteEntity(
                title = "sdfs",
                description = "sldkf"
            ),
            NoteEntity(
                title = "sdfs",
                description = "sldkf"
            ),
            NoteEntity(
                title = "sdfs",
                description = "sldkf"
            ),
    )

    NotesContent(
        list,
        onClick = {}
    )
}