package com.bemos.notescompose.ui.presentation.screen.notes.adapter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Note

@Composable
fun NoteItem(item: Note) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 15.dp)
    ) {
        Column(
            Modifier.padding(10.dp)
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
            )

            Text(
                text = item.description
            )
        }
    }
}