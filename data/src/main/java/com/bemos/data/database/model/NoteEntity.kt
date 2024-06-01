package com.bemos.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bemos.domain.model.Note

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
    Note(
        id,
        title,
        description
    )
}

fun Note.toEntity() = run {
    NoteEntity(
        id,
        title,
        description
    )
}