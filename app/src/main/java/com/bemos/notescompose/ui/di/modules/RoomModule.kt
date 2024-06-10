package com.bemos.notescompose.ui.di.modules

import android.content.Context
import androidx.room.Room
import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.db.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        context: Context
    ) : NoteDatabase {
        return Room.databaseBuilder(
            context = context,
            NoteDatabase::class.java,
            "db"
        ).build()
    }

    @Provides
    fun provideGetDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.getDao()
    }

}