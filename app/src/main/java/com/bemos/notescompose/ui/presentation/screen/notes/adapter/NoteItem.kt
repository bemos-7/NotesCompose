package com.bemos.notescompose.ui.presentation.screen.notes.adapter

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun NoteItem(item: Note, onClick: (Int) -> Unit) {

    var id by remember {
        mutableStateOf(0)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 15.dp)
            .clickable {
                id = item.id!!

                onClick(id)
            }
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