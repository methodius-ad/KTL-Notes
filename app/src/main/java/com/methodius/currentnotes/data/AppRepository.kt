package com.methodius.currentnotes.data

import androidx.lifecycle.LiveData

class AppRepository(private val notesDao: NotesDao) {

    val getData: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun addNote(note: Note) {
        notesDao.insertNote(note)
    }
}