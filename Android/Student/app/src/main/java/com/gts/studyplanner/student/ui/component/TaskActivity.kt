package com.gts.studyplanner.student.ui.component

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.gts.studyplanner.student.R
import com.gts.studyplanner.student.data.model.Task
import com.gts.studyplanner.student.ui.adapter.TaskAdapter
import kotlinx.android.synthetic.main.activity_task.*
import org.jetbrains.anko.AnkoLogger
import java.util.*

class TaskActivity : AppCompatActivity(), AnkoLogger {

    lateinit var listAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        initToolbar()

        with(list) {
            setHasFixedSize(true)
            layoutManager = android.support.v7.widget.LinearLayoutManager(this@TaskActivity)
            listAdapter = TaskAdapter()
            adapter = listAdapter
        }
        val task = Task()
        task.updatedAt = Calendar.getInstance()
        listAdapter.add(task)
    }

    private fun initToolbar(): Toolbar {
        val toolbar = toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return toolbar
    }

}
