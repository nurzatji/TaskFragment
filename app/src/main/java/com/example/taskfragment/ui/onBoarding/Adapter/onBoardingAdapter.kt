package com.example.taskfragment.ui.onBoarding.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskfragment.databinding.FragmentOnBoardBinding
import com.example.taskfragment.databinding.ItemOnBoardingBinding
import com.example.taskfragment.ui.Model.onBoard
import com.example.taskfragment.ui.utils.loadImage

class onBoardingAdapter(private val onStart:()-> Unit):androidx.recyclerview.widget.RecyclerView.Adapter<onBoardingAdapter.OnBoardingViewHolder>() {
    val  data  = arrayListOf<onBoard>(
        onBoard("Simple","Description1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ43ME1NY04FdIP7gzJu8Bi04Au1t-Ox50qphVwUpmen5nd9YOotwlHBPVIpi6N4kA9HVU&usqp=CAU"),
        onBoard("Convenience","Description2","https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"),
        onBoard("Protected","Description2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxXsjHN7AGQXHs6nrM68gnMPtkttD4Wpxt2U2uCT4kt42RW0f_Pb7L7dwJzdi8Os--d5A&usqp=CAU"),

    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
holder.bind(data[position])
    }

    override fun getItemCount(): Int {
return  data.size
    }

inner  class OnBoardingViewHolder(private val binding:ItemOnBoardingBinding):ViewHolder(binding.root
) {
    fun bind(onBoard: onBoard) {

            binding.btnStart.isVisible =adapterPosition==2
            binding.btnSkip.isVisible = adapterPosition!=2
binding.btnSkip.setOnClickListener{
    onStart()
}
binding.btnStart.setOnClickListener{
    onStart()
}


        binding.titil.text = onBoard.title
        binding.description.text = onBoard.title
        binding.imgBoard.loadImage(onBoard.image.toString())
    }

}
}