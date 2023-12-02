package com.liilab.dependancyinjectionapplication.data.repository

import com.liilab.dependancyinjectionapplication.data.datasource.local.dao.NoteDao
import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note
import com.liilab.dependancyinjectionapplication.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun createNote(
        title: String,
        content: String,
        authorName: String,
        isSpecial: Boolean
    ) {
        val note = Note(
            title = title,
            content = content,
            authorName = authorName,
            isSpecial = isSpecial
        )
        noteDao.insertAll(note = arrayOf(note))
    }

    override suspend fun getNotes(): List<Note> {
        return noteDao.getAllNotes()
    }
}