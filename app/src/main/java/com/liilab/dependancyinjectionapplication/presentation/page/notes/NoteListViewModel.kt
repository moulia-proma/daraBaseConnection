package com.liilab.dependancyinjectionapplication.presentation.page.notes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liilab.dependancyinjectionapplication.data.datasource.local.model.Note
import com.liilab.dependancyinjectionapplication.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    fun createNote(title: String, content: String, authorName: String, isSpecial: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.createNote(
                title = title,
                content = content,
                authorName = authorName,
                isSpecial = isSpecial
            )
            getNotes()
        }
    }

    val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList: StateFlow<List<Note>> = _noteList.asStateFlow()
    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = noteRepository.getNotes()
               _noteList.value = notes
        }
    }
}