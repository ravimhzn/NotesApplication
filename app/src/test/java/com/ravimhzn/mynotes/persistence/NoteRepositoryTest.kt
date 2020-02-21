package com.ravimhzn.mynotes.persistence


import com.ravimhzn.mynotes.Resource
import com.ravimhzn.mynotes.repository.NoteRepository
import com.ravimhzn.mynotes.repository.NoteRepository.Companion.INSERT_SUCCESS
import com.ravimhzn.mynotes.util.TestUtil
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NoteRepositoryTest {

    val TIMESTAMP_1 = "05-2019"
    private val NOTE1 = Note("Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1)


    @Test
    fun givenServiceMock_whenCallingMockedMethod_thenCorrectlyVerified() {
        // given
        val service = mockk<NoteRepository>()
        every { service.getDataFromDb("Expected Param") } returns "Expected Output"

        // when
        val result = service.getDataFromDb("Expected Param")

        // then
        verify { service.getDataFromDb("Expecated Param") }
        println("RESULT::$result")
        assertEquals("Expected Output", result)
    }

    @Test
    fun testExpectedActual() {
        assertEquals(2, 3, "comparison failed")
    }

    @Test
    fun `noteRepositoryInsertNote Test if it returns 1 test2`() {
//        //Given
        val noteDao = mockk<NoteDao>()
        val noteRepository = NoteRepository(noteDao)

        val insertedRow = 1L
        val expectedData: Single<Long> = Single.just(insertedRow)
        every { noteDao.insertNote(NOTE1) } returns expectedData

        //When
        val returnedData: Resource<Int> =
            noteRepository.noteRepositoryInsertNote(NOTE1).blockingSingle()
        println("RETURNED DATA:: $returnedData")

        //Then
        verify { noteDao.insertNote(any()) }
        println("RAW RETURNED DATA:: ${returnedData.message}, ${returnedData.data}")
        assertEquals(Resource.Success(INSERT_SUCCESS, 1), returnedData)
    }
}