package com.liilab.dependancyinjectionapplication.presentation.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.databinding.FragmentCreateNoteBinding
import com.liilab.dependancyinjectionapplication.presentation.page.notes.NoteListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateNoteFragment : DialogFragment() {

    private val viewModel: NoteListViewModel by activityViewModels()

    private var _binding: FragmentCreateNoteBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveNote.setOnClickListener {
            Log.d("_xyz", "onViewCreated: clicked")
            viewModel.createNote(
                title = binding.noteTitle.text.toString(),
                content = binding.noteContent.text.toString(),
                authorName = binding.noteAuthorName.text.toString(),
                isSpecial = binding.checkbox.isChecked
            )
            dialog?.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val TAG = "CreateNoteDialog"
    }

}