package com.ravimhzn.mynotes.di

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.ravimhzn.mynotes.persistence.NoteDao
import com.ravimhzn.mynotes.persistence.NoteDatabase
import com.ravimhzn.mynotes.persistence.NoteDatabase.Companion.DATABASE_NAME
import com.ravimhzn.mynotes.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun testString(): String {
        return "This is a test String to check if Dagger is working or not"
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return databaseBuilder(
            application,
            NoteDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.getNoteDao()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }

}