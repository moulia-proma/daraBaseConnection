package com.liilab.dependancyinjectionapplication.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.liilab.dependancyinjectionapplication.data.datasource.local.dao.NoteDao
import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note


@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}