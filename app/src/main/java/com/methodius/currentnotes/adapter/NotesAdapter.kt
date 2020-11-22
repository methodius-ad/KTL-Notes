package com.methodius.currentnotes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.methodius.currentnotes.screens.NotesEditorActivity
import com.methodius.currentnotes.R
import com.methodius.currentnotes.model.Note

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    private var notesList = emptyList<Note>()

class NotesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title_text)

    fun f() {
        title.setOnClickListener {
            val context = itemView.context

            val intent: Intent = Intent((Intent(context, NotesEditorActivity::class.java)))
            intent.putExtra("", title.text)

        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_item, parent, false)
        return NotesHolder(view)
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.title.text = notesList[position].title


        holder.title.setOnClickListener {
            val context = holder.itemView.context

            val intent = Intent((Intent(context, NotesEditorActivity::class.java)))
            intent.putExtra("title", notesList[position].title)
            intent.putExtra("text", notesList[position].text)
            intent.putExtra("id", notesList[position].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun setData(list: List<Note>) {
        notesList = list
        notifyDataSetChanged()
    }



}