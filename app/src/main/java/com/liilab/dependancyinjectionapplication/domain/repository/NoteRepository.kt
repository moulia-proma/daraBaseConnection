package com.liilab.dependancyinjectionapplication.domain.repository

import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note


interface NoteRepository {
    suspend fun createNote(
        title: String,
        content: String,
        authorName: String,
        isSpecial: Boolean
    )

    suspend fun getNotes() : List<Note>
}