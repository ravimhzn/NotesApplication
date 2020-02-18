package com.ravimhzn.mynotes.repository

import com.ravimhzn.mynotes.persistence.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(private val noteDao: NoteDao)