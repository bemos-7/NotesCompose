package com.bemos.notescompose.ui.di.modules

import android.content.Context
import com.bemos.data.database.db.NoteDatabase
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideDatabase(context: Context) : NoteDatabase {
        return NoteDatabase.getDb(context)
    }

    @Provides
    fun provideNoteRepository(noteDatabase: NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(noteDatabase.getDao())
    }

}