package com.liilab.dependancyinjectionapplication.data.datasource.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "content") val content: String?,
    @ColumnInfo(name = "author_name") var authorName: String?,
    @ColumnInfo(name = "is_special") val isSpecial: Boolean = false
)