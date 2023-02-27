package com.example.taskfragment.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskfragment.App
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
        adapter = TaskAdapter(this::onLongClickListener)
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
        setData()
        val  task  = App.App.dp.taskDao().getAll()
        adapter.addTask(task)

    }
    private fun onLongClickListener(task: Task){
        val alert = AlertDialog.Builder(requireContext())
       alert.setTitle("Delete?")
       alert.setPositiveButton("Yes"){dialog,_->
            App.App.dp.taskDao()?.delete(task)
           dialog.dismiss()
            setData()

        }
        alert.setNegativeButton("No"){dialog,_->
            dialog.dismiss()

        }
       alert.create().show()
    }

    private fun setData() {
     val task = App.App.dp.taskDao().getAll()
        adapter.addTask(task)
    }



}