package com.example.todolistsertificate.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistsertificate.R
import com.example.todolistsertificate.data.models.response.TaskPayload
import com.example.todolistsertificate.databinding.ItemTasksBinding


class TaskAdapter : RecyclerView.Adapter<TaskAdapter.VH>() {
    var model: MutableList<TaskPayload> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
//    var onItemClickListener: ((TaskPayload) -> Unit)? = null
//    fun setOnMenuItemCLickListener(block: (TaskPayload) -> Unit) {
//        onItemClickListener = block
//    }

    inner class VH(val binding: ItemTasksBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun getItemCount(): Int = model.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        val binding = ItemTasksBinding.bind(view)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val task = model[position]

        holder.binding.apply {
            checkbox.isChecked = task.isDone
            checkbox.isEnabled != task.isDone
            tvTaskPermission.text = task.description
            tvTaskName.text = task.task

//            tvTaskPermission.paint.isStrikeThruText = task.isDone

//            delete.setOnClickListener {
//                onClick.invoke(task,model.indexOf(task))
//            }

//            checkbox.setOnClickListener {
//                checkboxClick.invoke(task)
//            }

//            root.setOnLongClickListener()
        }
    }

    private var checkboxClick: (data: TaskPayload) -> Unit ={}
    fun setOnCheckbox(checkboxClick : (data: TaskPayload) -> Unit) {
        this.checkboxClick = checkboxClick
    }

    private var onClick: (data: TaskPayload, position: Int) -> Unit = { text, position -> }
    fun removeItemClick(itemClick: (data: TaskPayload, position: Int) -> Unit) {
        this.onClick = itemClick
    }

    fun removeTask(position: Int) {
        if (model.size > 0){
            model.removeAt(position)
            notifyItemRemoved(position)
        }
    }

}
