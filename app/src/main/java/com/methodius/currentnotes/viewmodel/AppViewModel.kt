package com.methodius.currentnotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.methodius.currentnotes.database.AppDatabase
import com.methodius.currentnotes.repository.AppRepository
import com.methodius.currentnotes.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application) {

    val data: LiveData<List<Note>>
    private val repository: AppRepository

    init {
        val notesDao = AppDatabase.getDatabase(application).notesDao()
        repository = AppRepository(notesDao)
        data = repository.getData
    }

     fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }
}