package com.methodius.currentnotes.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.methodius.currentnotes.R
import com.methodius.currentnotes.viewmodel.AppViewModel
import com.methodius.currentnotes.model.Note

class NotesEditorActivity : AppCompatActivity() {

    lateinit var mViewModel: AppViewModel
    var isNew: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_editor)

        val saveButton: FloatingActionButton = findViewById(R.id.save_button)

        mViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        val editTitle: EditText = findViewById(R.id.title_edit)
        val editNote: EditText = findViewById(R.id.note_edit)

        if (intent.hasExtra("title")) {
            isNew = false

            val title: String? = intent.getStringExtra("title")
            val text: String? = intent.getStringExtra("text")

            editTitle.setText(title)
            editNote.setText(text)
        } else {
            Log.d("extra-logs", "have no extra")
        }

        saveButton.setOnClickListener {

            if(isNew) {
                saveNote(editTitle.text.toString(), editNote.text.toString())
                finish()
            } else {
                updateNote(editTitle.text.toString(), editNote.text.toString())
                finish()
            }
        }

    }

    fun saveNote(title1: String, text1: String) {
        val note: Note = Note(0, title1, text1)
        mViewModel.addNote(note)
    }

    fun updateNote(title1: String, text1: String) {
        val pos = intent.getLongExtra("id", 0)
        val note: Note = Note(pos, title1, text1)
        mViewModel.updateNote(note)
    }

    fun deleteNote(id: Int, title1: String, text1: String) {
        val note: Note = Note(id.toLong(), title1, text1)
        mViewModel.updateNote(note)
    }
}