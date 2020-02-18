package com.ravimhzn.mynotes.util

import com.ravimhzn.mynotes.models.Note
import java.util.*
import kotlin.collections.ArrayList


object TestUtil {
    var TIMESTAMP_1 = "05-2020"
    var TEST_NOTE_1 = Note(
        title = "Take out the trash",
        content = "It's garbage day tomorrow.",
        timestamp = TIMESTAMP_1
    )

    var TIMESTAMP_2 = "06-2020"

    var TEST_NOTE_2 = Note(
        title = "Anniversary Gift",
        content = "Buy an anniversary gift.",
        timestamp = TIMESTAMP_2
    )

    var TEST_NOTES_LIST = Collections.unmodifiableList(testNoteList())

    fun testNoteList(): ArrayList<Note> {
        var t = ArrayList<Note>()
        t.add(
            Note(
                title = "Take out the trash",
                content = "It's garbage day tomorrow.",
                timestamp = TIMESTAMP_1
            )
        )
        t.add(
            Note(
                title = "Anniversary Gift",
                content = "Buy an anniversary gift.",
                timestamp = TIMESTAMP_2
            )
        )
        return t
    }

}