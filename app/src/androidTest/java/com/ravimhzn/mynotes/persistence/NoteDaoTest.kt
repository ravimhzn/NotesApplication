package com.ravimhzn.mynotes.persistence

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ravimhzn.mynotes.models.Note
import com.ravimhzn.mynotes.util.LiveDataTestUtil
import com.ravimhzn.mynotes.util.TestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test


class NoteDaoTest : NoteDatabaseTest() {
    companion object {
        val TEST_TITLE = "This is a test title"
        val TEST_CONTENT = "This is some test content"
        val TEST_TIMESTAMP = "08-2018"
    }

    /**
     * When we use @Rule only it will throw an error
     * org.junit.internal.runners.rules.ValidationError: The @Rule 'activityTestRule' must be public.
     * For more info: https://proandroiddev.com/fix-kotlin-and-new-activitytestrule-the-rule-must-be-public-f0c5c583a865
     */
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    /*
        Insert, Read, Delete
     */
    @Test
    fun InsertReadDelete() {

        var note = TestUtil.TEST_NOTE_1
        // insert
        getNoteDao().insertNote(note).blockingGet()// wait until inserted
        //read
        var liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes: List<Note> = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)

        assertEquals(note.content, insertedNotes[0].content)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)
        assertEquals(note.title, insertedNotes[0].title)

        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(0, insertedNotes.size)
    }


    /*
        Insert, Read, Update, Read, Delete,
     */
    @Test
    fun InsertReadUpdateReadDelete() {
        var note = TestUtil.TEST_NOTE_1
        // insert
        getNoteDao().insertNote(note).blockingGet()// wait until inserted

        //read
        var liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes: List<Note> = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)
        assertEquals(note.content, insertedNotes[0].content)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)
        assertEquals(note.title, insertedNotes[0].title)
        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // update
        note.title = TEST_TITLE
        note.content = TEST_CONTENT
        note.timestamp = TEST_TIMESTAMP
        getNoteDao().updateNote(note).blockingGet()

        // read
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(TEST_TITLE, insertedNotes[0].title);
        assertEquals(TEST_CONTENT, insertedNotes[0].content)
        assertEquals(TEST_TIMESTAMP, insertedNotes[0].timestamp)
        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(0, insertedNotes.size)
    }


    /*
        Insert note with null title, throw exception

         @Test(expected = SQLiteConstraintException::class)
        fun insert_nullTitle_throwSQLiteConstraintException() {
        var note = TestUtil.TEST_NOTE_1
        note.title = null
        // insert
        getNoteDao().insertNote(note).blockingGet();
    }

     */


    /*
        Insert, Update with null title, throw exception
     */
}