package com.methodius.currentnotes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.methodius.currentnotes.model.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun getNoteById(id: Long): Note

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}