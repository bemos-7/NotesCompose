package com.bemos.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String
)

fun NoteEntity.toDomain() = run {
    com.bemos.domain.model.Note(
        id, title, description
    )
}

fun com.bemos.domain.model.Note.toEntity() = run {
    NoteEntity(
        id, title, description
    )
}