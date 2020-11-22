package com.methodius.currentnotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val title: String,
        val text: String)