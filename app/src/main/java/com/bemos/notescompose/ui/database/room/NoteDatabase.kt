package com.bemos.notescompose.ui.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bemos.notescompose.ui.database.model.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase() : RoomDatabase() {
    abstract fun getDao(): NoteDao

    companion object {
        fun getDb(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                context = context,
                NoteDatabase::class.java,
                "db"
            ).build()
        }
    }

}