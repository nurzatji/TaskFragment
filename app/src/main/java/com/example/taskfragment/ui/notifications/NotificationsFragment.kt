package com.example.taskfragment.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfragment.databinding.FragmentNotificationsBinding
import com.example.taskfragment.model.Quote
import com.example.taskfragment.ui.notifications.adapter.QuoteAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
private val adapter= QuoteAdapter()
    private lateinit var db:FirebaseFirestore

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db= FirebaseFirestore.getInstance()
        binding.recyclerView.adapter = adapter
db.collection(FirebaseAuth.getInstance().currentUser?.uid.toString()).get().addOnSuccessListener {
val data = it.toObjects(Quote::class.java)
    adapter.addQuote(data)
}.addOnFailureListener {

}
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}