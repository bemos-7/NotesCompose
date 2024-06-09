package com.bemos.notescompose.ui.di.modules

import com.bemos.domain.repository.NoteRepository
import com.bemos.domain.usecases.DeleteNoteUseCase
import com.bemos.domain.usecases.GetAllNotesUseCase
import com.bemos.domain.usecases.InsertNoteUseCase
import com.bemos.domain.usecases.UpdateNoteUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideInsertNoteUseCase(noteRepository: NoteRepository) : InsertNoteUseCase {
        return InsertNoteUseCase(noteRepository)
    }

    @Provides
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository) : UpdateNoteUseCase {
        return UpdateNoteUseCase(noteRepository)
    }

    @Provides
    fun provideGetAllNotesUseCase(noteRepository: NoteRepository) : GetAllNotesUseCase {
        return GetAllNotesUseCase(noteRepository)
    }

    @Provides
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository) : DeleteNoteUseCase {
        return DeleteNoteUseCase(noteRepository)
    }

}