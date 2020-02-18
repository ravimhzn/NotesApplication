package com.ravimhzn.mynotes.models

import com.ravimhzn.mynotes.util.TestUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NoteTest {

    var TIMESTAMP1: String = "05-2020"
    var TIMESTAMP2: String = "05-2019"

//    var testUtil: Int = TestUtil.NOTE//test-common directory test

    /**
     * Compare Two equal notes
     */
    @Test
    internal fun isNotesEqual_identicalProperties_returnTrue() {
        var note1 = Note(1, "Kotlin", "Kotlin is wonderful", TIMESTAMP1)
        var note2 = Note(1, "Kotlin", "Kotlin is wonderful", TIMESTAMP1)

        Assertions.assertEquals(note1, note2)
        println("The notes are equal")
    }

    /*
    Compare Notes with two different Ids
     */
    @Test
    internal fun isNotesNotEqual_identicalProperties_returnFalse() {
        var note1 = Note(1, "Kotlin", "Kotlin is wonderful", TIMESTAMP1)
        var note2 = Note(2, "Kotlin", "Kotlin is wonderful", TIMESTAMP2)

        Assertions.assertNotEquals(note1, note2)
        println("The notes are not equal")
    }
}