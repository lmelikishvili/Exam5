package com.example.exam5.cource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exam5.databinding.ActivecourceItemBinding

class ActiveCourceRvAdapter: ListAdapter<ActiveCourse, ActiveCourceRvAdapter.ActiveCourceVH>(ActiveCourceRvAdapter.ActiveCourceDiffUtil()) {

    class ActiveCourceDiffUtil : DiffUtil.ItemCallback<ActiveCourse>() {
        override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCourceVH = ActiveCourceVH(
        ActivecourceItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))


    override fun onBindViewHolder(holder: ActiveCourceVH, position: Int) {
        holder.bind()
    }

    inner class ActiveCourceVH(private val binding: ActivecourceItemBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var activeCource: ActiveCourse
        fun bind() {
            activeCource = currentList[adapterPosition]
            with(binding) {
                tvBookinkTime.text = "${activeCource.booking_time}"

            }
            Glide.with(binding.root)
                .load(activeCource.image)
                .into(binding.ivCourceImage)
        }

    }
}