package com.ravimhzn.mynotes.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ravimhzn.mynotes.models.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "notes_db"
    }

    abstract fun getNoteDao(): NoteDao
}