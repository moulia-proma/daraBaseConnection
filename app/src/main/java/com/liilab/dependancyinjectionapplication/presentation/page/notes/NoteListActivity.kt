package com.liilab.dependancyinjectionapplication.presentation.page.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.liilab.dependancyinjectionapplication.databinding.ActivityNoteListBinding
import com.liilab.dependancyinjectionapplication.presentation.dialogs.CreateNoteFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding
    private val viewModel: NoteListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getNotes()
                viewModel.noteList.collectLatest {
                    binding.textNoteCount.text = it.size.toString()
                    val Adapter = NotesAdapter(this@NoteListActivity, it)
                    binding.recyclerViewNotes.adapter = Adapter
                }
            }
        }
        binding.btnCreateNote.setOnClickListener {
            val dialog = CreateNoteFragment()
            dialog.show(supportFragmentManager, "CreateNoteDialog")
        }


        /*
                binding.btnCreateNote.setOnClickListener {
                    viewModel.createNote(
                        title = "Learning Room Database",
                        content = "You would also need to update the AndroidManifest file and select " +
                                "the BaseApplication as the application entry point " +
                                "<application android:name=\"path.to.BaseApplication\" ... " +
                                "to allow Android to take advantage of Dagger-Hilt.",
                        authorName = "Proma",
                        isSpecial = true
                    )
                }*/
    }
}