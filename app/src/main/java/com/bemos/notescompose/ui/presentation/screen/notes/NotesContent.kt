package com.bemos.notescompose.ui.presentation.screen.notes

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.bemos.notescompose.R
import com.bemos.notescompose.ui.presentation.screen.notes.adapter.NoteItem
import com.bemos.data.database.entity.NoteModel

@Composable
fun NotesContent(
    listNote: List<com.bemos.data.database.entity.NoteModel>,
    onClick: () -> Unit
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
                NoteItem(item = it)
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

    val list: List<com.bemos.data.database.entity.NoteModel> = listOf(
        com.bemos.data.database.entity.NoteModel(
            title = "sdfs",
            description = "sldkf"
        ),
        com.bemos.data.database.entity.NoteModel(
            title = "sdfs",
            description = "sldkf"
        ),
        com.bemos.data.database.entity.NoteModel(
            title = "sdfs",
            description = "sldkf"
        ),
    )

    NotesContent(
        list,
        onClick = {}
    )
}