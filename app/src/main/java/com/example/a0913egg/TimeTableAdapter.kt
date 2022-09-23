//package com.example.a0913egg
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.ListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import java.util.*
//
//
//class TimeTableAdapter : ListAdapter<TimeTableModel, TimeTableAdapter.ViewHolder>(diffUtil) {
//    inner class ViewHolder (private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(timetableModel: TimeTableModel){
//
//            val date = Date(timetableModel.createdAt)
//
//            binding.titleTextView.text = timetableModel.name
//            binding.dateTextView.text = timetableModel.time
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(currentList[position])
//    }
//
//    companion object{
//        val diffUtil = object  : DiffUtil.ItemCallback<TimeTableModel>(){
//            override fun areItemsTheSame(oldItem: TimeTableModel, newItem: TimeTableModel): Boolean {
//                return oldItem.createdAt == newItem.createdAt
//            }
//
//            override fun areContentsTheSame(oldItem: TimeTableModel, newItem: TimeTableModel): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}
//
