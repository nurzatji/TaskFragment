package com.example.taskfragment.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskfragment.databinding.ItemTaskBinding
import com.example.taskfragment.model.Task

class TaskAdapter(private val onLongClick:(Task) ->Unit) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val data = arrayListOf<Task>()

    fun addTask(task: List<Task>) {
      data.clear()
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       holder.bind(data[position])

        }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            itemView.setOnLongClickListener {
                onLongClick(task)
                false
            }
            with(binding) {
               title.text = task.title
                description.text = task.description

                }
            }




        }

    }




