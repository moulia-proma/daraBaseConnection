package com.liilab.dependancyinjectionapplication.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id IN (:noteIds)")
    fun loadAllNotesByIds(noteIds: IntArray): List<Note>

    @Insert
    fun insertAll(vararg note: Note)

    @Delete
    fun delete(note: Note)
}