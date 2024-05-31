package com.bemos.domain.repository

import androidx.lifecycle.LiveData
import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.entity.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes() : Flow<List<com.bemos.data.database.entity.NoteModel>>

    suspend fun insert(note: com.bemos.data.database.entity.NoteModel)

}