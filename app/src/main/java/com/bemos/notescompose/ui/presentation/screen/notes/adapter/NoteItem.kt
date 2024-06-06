package com.bemos.notescompose.ui.presentation.screen.notes.adapter

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteItem(item: Note, onClick: (Int, Note) -> Unit, onLongClick: (Note) -> Unit) {

    var id by remember {
        mutableStateOf(0)
    }

    var note by remember {
        mutableStateOf(
            Note(
                title = "",
                description = ""
            )
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .combinedClickable(
                onClick = {
                    note = Note(
                        item.id,
                        item.title,
                        item.description
                    )
                    id = item.id!!
                    onClick(
                        id,
                        note
                    )
                },
                onLongClick = {
                    note = Note(
                        item.id,
                        item.title,
                        item.description
                    )
                    onLongClick(note)
                }
            )
    ) {
        Column(
            Modifier.padding(10.dp)
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Text(
                text = item.description
            )
        }
    }
}