package com.liilab.dependancyinjectionapplication.presentation.page.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note

class NotesAdapter(
    private val context: Context,
    private val data: List<Note>
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ViewHolder {
        val notesView = LayoutInflater.from(context).inflate(R.layout.note_list, parent, false)

        return NotesAdapter.ViewHolder(notesView)
    }

    override fun onBindViewHolder(holder: NotesAdapter.ViewHolder, position: Int) {
        val posData = data[position]
        holder.setData(posData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.text_note_title)
        private val des: TextView = view.findViewById(R.id.text_note_author_name)

        fun setData(dataPos:Note) {
            title.text = dataPos.title
            des.text = dataPos.authorName
        }

    }

}