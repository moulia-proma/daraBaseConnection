package com.liilab.dependancyinjectionapplication.presentation.page.pixabay

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.Hit
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PixabayItemResponse


class CustomPixelbayAdapter(

    val context: Context,
    private val images: PixabayItemResponse
) : RecyclerView.Adapter<CustomPixelbayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val pixelImageView =
            LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false)
        return CustomPixelbayAdapter.ViewHolder(pixelImageView)
    }

    override fun getItemCount(): Int {
        return images.hits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images.hits[position]
        holder.setData(image, context)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.image_view)

        fun setData(image: Hit, context: Context) {
            Glide.with(view).load(image.largeImageURL).centerCrop().into(imageView)

            imageView.setOnClickListener {
                val intent = Intent(context, ImageDetailsActivity::class.java)
                intent.putExtra("img", "${image.largeImageURL}")
                intent.putExtra("views", "${image.views}")
                intent.putExtra("likes", "${image.likes}")
                intent.putExtra("downloads", "${image.downloads}")

                startActivity(context, intent, null)

            }
        }

    }
}