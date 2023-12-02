package com.liilab.dependancyinjectionapplication.presentation.page.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liilab.dependancyinjectionapplication.R
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse

class CustomRecyclerAdapter(
    private val context: Context,
    private val data: List<PlaceholderImageItemResponse>
) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val retrofitView = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false)
        return ViewHolder(retrofitView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataPos = data[position]
        holder.setData(dataPos)

    }

    class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.image_view)
        fun setData(dataSource: PlaceholderImageItemResponse) {
            Glide.with(view).load(dataSource.url).into(imageView)
        }
    }


}