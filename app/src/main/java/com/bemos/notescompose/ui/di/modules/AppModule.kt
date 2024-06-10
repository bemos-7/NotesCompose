package com.bemos.notescompose.ui.di.modules

import com.bemos.domain.usecases.DeleteNoteUseCase
import com.bemos.domain.usecases.GetAllNotesUseCase
import com.bemos.domain.usecases.InsertNoteUseCase
import com.bemos.domain.usecases.UpdateNoteUseCase
import com.bemos.notescompose.ui.presentation.screen.add_note.vm.factory.AddNoteViewModelFactory
import com.bemos.notescompose.ui.presentation.screen.notes.vm.factory.NotesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAddNoteViewModelFactory(
        insertNoteUseCase: InsertNoteUseCase,
        updateNoteUseCase: UpdateNoteUseCase
    ) : AddNoteViewModelFactory {
        return AddNoteViewModelFactory(
            insertNoteUseCase = insertNoteUseCase,
            updateNoteUseCase = updateNoteUseCase
        )
    }

    @Provides
    fun provideNotesViewModelFactory(
        getAllNotesUseCase: GetAllNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase
    ) : NotesViewModelFactory {
        return NotesViewModelFactory(
            getAllNotesUseCase = getAllNotesUseCase,
            deleteNoteUseCase = deleteNoteUseCase
        )
    }

}