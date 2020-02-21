package com.ravimhzn.mynotes.repository

import com.ravimhzn.mynotes.Resource
import com.ravimhzn.mynotes.models.Note
import com.ravimhzn.mynotes.persistence.NoteDao
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    companion object {
        val NOTE_TITLE_NULL = "Note title cannot be null"
        val INVALID_NOTE_ID = "Invalid id. Can't delete note"
        val DELETE_SUCCESS = "Delete success"
        val DELETE_FAILURE = "Delete failure"
        val UPDATE_SUCCESS = "Update success"
        val UPDATE_FAILURE = "Update failure"
        val INSERT_SUCCESS = "Insert success"
        val INSERT_FAILURE = "Insert failure"
    }

    private val timeDelay = 0
    private val timeUnit: TimeUnit = TimeUnit.SECONDS

    fun noteRepositoryInsertNote(note: Note): Flowable<Resource<Int>> {
        note.title?.let {
            return noteDao.insertNote(note)
                .delaySubscription(timeDelay.toLong(), timeUnit)
                .map {
                    it.toInt()
                }
                .onErrorReturn() {
                    -1
                }.map(object : Function<Int, Resource<Int>> {
                    override fun apply(t: Int): Resource<Int> {
                        if (t > 0) {
                            return Resource.Success(INSERT_SUCCESS, t)
                        }
                        return Resource.Error(message = INSERT_FAILURE)
                    }
                })
                .subscribeOn(Schedulers.io())
                .toFlowable() //By default, LiveData only support Flowables. So we need to convert Single to Flowable
        }
    }

    fun getDataFromDb(testParameter: String): String {
        return "Ravi"
    }
}
