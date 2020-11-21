package com.methodius.currentnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.methodius.currentnotes.data.AppViewModel
import com.methodius.currentnotes.data.Note

class NotesEditorActivity : AppCompatActivity() {

    lateinit var mViewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_editor)

        val saveButton: FloatingActionButton = findViewById(R.id.save_button)

        mViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        val editTitle: EditText = findViewById(R.id.title_edit)
        val editNote: EditText = findViewById(R.id.note_edit)

        saveButton.setOnClickListener {
            db(editTitle.text.toString(), editNote.text.toString())
            finish()
        }


        if(intent.hasExtra("title")) {
            val title: String? = intent.getStringExtra("title")
            val text: String? = intent.getStringExtra("text")

            editTitle.setText(title)
            editNote.setText(text)
        } else {
            Log.d("extra-logs", "have no extra")
        }

    }

    fun db(title1: String, text1: String) {

        val note: Note = Note(0, title1, text1)
        mViewModel.addNote(note)
    }
}