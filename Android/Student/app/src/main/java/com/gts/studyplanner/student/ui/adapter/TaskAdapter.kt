package com.gts.studyplanner.student.ui.adapter

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.gts.studyplanner.student.R
import com.gts.studyplanner.student.data.model.Task
import com.gts.studyplanner.student.data.repo.TaskRepo
import kotlinx.android.synthetic.main.card_task.view.*
import java.util.*


class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskCardHolder>() {

    private val mTasks: MutableList<Task> = TaskRepo.getAll()
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Task
            item.updatedAt = Calendar.getInstance()
            item.save()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskCardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskCardHolder(layoutInflater.inflate(R.layout.card_task, parent, false))
    }

    override fun onBindViewHolder(holder: TaskCardHolder, position: Int) {
        val item = mTasks[position]
        val date = item.updatedAt.timeInMillis

        val color = "#" + date.toString().substring(7)
        holder.card.setCardBackgroundColor(Color.parseColor(color))
        holder.title.text = color
        holder.date.text = DateFormat.format("hh:mm:ss", Date(date))

        with(holder.container) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int {
        return mTasks.size
    }

    fun add(item: Task) {
        mTasks.add(item)
        item.save()
        notifyItemInserted(0)
    }

    class TaskCardHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.card
        val container: LinearLayout = view.container
        val title: TextView = view.title
        val date: TextView = view.date
    }
}