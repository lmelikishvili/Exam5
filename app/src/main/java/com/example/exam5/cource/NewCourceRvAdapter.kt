package com.example.exam5.cource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.databinding.NewcourceItemBinding

class NewCourceRvAdapter: ListAdapter<NewCourse, NewCourceRvAdapter.NewCourceVH>(NewCourceDiffUtil()) {

    class NewCourceDiffUtil : DiffUtil.ItemCallback<NewCourse>() {
        override fun areItemsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCourceVH = NewCourceVH(
        NewcourceItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))


    override fun onBindViewHolder(holder: NewCourceVH, position: Int) {
        holder.bind()
    }

    inner class NewCourceVH(private val binding: NewcourceItemBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var newCource: NewCourse
        fun bind() {
            newCource = currentList[adapterPosition]
            with(binding) {
                tvDuration.text = "${newCource.duration}"
                tvQuestion.text = "${newCource.question}"
                tvTitle.text = "${newCource.title}"
            }
//            Glide.with(binding.root)
//                .load(user.avatar)
//                .into(binding.userImage)
        }

    }
}