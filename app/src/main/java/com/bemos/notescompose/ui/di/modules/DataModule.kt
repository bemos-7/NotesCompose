package com.bemos.notescompose.ui.di.modules

import android.content.Context
import com.bemos.data.database.dao.NoteDao
import com.bemos.data.database.db.NoteDatabase
import com.bemos.data.database.repository.NoteRepositoryImpl
import com.bemos.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }

}