package com.bemos.notescompose.ui.screen.notes.adapter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.notescompose.ui.database.model.NoteEntity

@Composable
fun NoteItem(item: NoteEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            Modifier
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = item.description
            )
        }
    }
}