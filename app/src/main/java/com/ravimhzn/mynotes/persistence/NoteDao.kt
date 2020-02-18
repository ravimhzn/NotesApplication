package com.ravimhzn.mynotes.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ravimhzn.mynotes.models.Note
import io.reactivex.Single

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note): Single<Long>

    @Query("Select * from notes")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note): Single<Int>

    @Update
    fun updateNote(note: Note): Single<Int>
}