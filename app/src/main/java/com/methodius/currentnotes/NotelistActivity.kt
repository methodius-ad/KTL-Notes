package com.methodius.currentnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.methodius.currentnotes.data.AppDatabase
import com.methodius.currentnotes.data.AppViewModel
import com.methodius.currentnotes.data.Note
import com.methodius.currentnotes.data.NotesDao

class NotelistActivity : AppCompatActivity() {

    private lateinit var mViewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notelist)

        val addButton: FloatingActionButton = findViewById(R.id.add_button)
        val list: List<Note> = listOf()




        val view: RecyclerView = findViewById(R.id.notes_list)
        val adapter = NotesAdapter()
        view.layoutManager = LinearLayoutManager(this)
        view.adapter = adapter

        mViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        mViewModel.data.observe(this, Observer {
          note -> adapter.setData(note)
        })

        addButton.setOnClickListener {
            startActivity(Intent(this, NotesEditorActivity::class.java))
        }


        //AppDatabase db = App.getInstance().getDatabase();
        //EmployeeDao employeeDao = db.employeeDao();

    }

    fun db() {

    }
}