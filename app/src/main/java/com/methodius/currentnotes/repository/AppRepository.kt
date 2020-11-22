package com.methodius.currentnotes.repository

import androidx.lifecycle.LiveData
import com.methodius.currentnotes.database.NotesDao
import com.methodius.currentnotes.model.Note

class AppRepository(private val notesDao: NotesDao) {

    val getData: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun addNote(note: Note) {
        notesDao.insertNote(note)
    }

    suspend fun updateNote(note: Note) {
        notesDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }
}