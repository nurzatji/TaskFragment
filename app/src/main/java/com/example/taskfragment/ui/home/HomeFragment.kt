package com.example.taskfragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskfragment.R
import com.example.taskfragment.databinding.FragmentHomeBinding
import com.example.taskfragment.ui.Model.Task
import com.example.taskfragment.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }

        setFragmentResultListener(RESULT_REQUEST_KEY) { key, bundle ->
            val result = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(result)
        }
        binding.recyclerView.adapter = adapter
    }
    companion object{
        const val RESULT_REQUEST_KEY = "requestKey"
        const val TASK_KEY = "task_key"
    }
}