package com.liilab.dependancyinjectionapplication.presentation.page.pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.databinding.ActivityImageDetailsBinding

class ImageDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getStringExtra("img")
        val views = intent.getStringExtra("views")
        val likes = intent.getStringExtra("likes")
        val downloads = intent.getStringExtra("downloads")


        Glide.with(this).load(image).centerCrop().placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView)

        binding.textViews.text = "Views = ${views}"
        binding.textDownloads.text = "Downloads = ${downloads}"
        binding.textLikes.text = "Likes = ${likes}"

    }
}