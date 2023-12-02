package com.liilab.dependancyinjectionapplication.presentation.page.pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.databinding.ActivityMainBinding
import com.liilab.dependancyinjectionapplication.presentation.page.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PixabayActivity : AppCompatActivity() {

    private val pixabayViewModel: PixabayViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pixabayViewModel.getPixabayImageList()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                pixabayViewModel.pixabayImages.collectLatest { images ->
                    Log.d("_xyx", "$images")
                    val adapter = images?.let { CustomPixelbayAdapter(this@PixabayActivity, it) }
                    val layoutManager =
                        GridLayoutManager(
                            this@PixabayActivity,
                            2,
                            GridLayoutManager.VERTICAL,
                            false
                        )

                    binding.recyclerView.layoutManager = layoutManager
                    binding.recyclerView.adapter = adapter
                }
            }
        }

    }
}