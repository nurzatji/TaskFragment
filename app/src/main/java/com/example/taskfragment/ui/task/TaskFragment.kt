package com.example.taskfragment.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskfragment.App
import com.example.taskfragment.databinding.FragmentTaskBinding
import com.example.taskfragment.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val task = Task(
                title = binding.titil.text.toString(),
                description = binding.description.text.toString()
            )
            App.App.dp.taskDao().insert(task)
            findNavController().navigateUp()
        }
    }

}
