package com.gts.studyplanner.student.data.model

import com.gts.studyplanner.student.data.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

@Table(name = "tasks", database = AppDatabase::class)
class Task : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "updated_at")
    var updatedAt: Calendar = Calendar.getInstance()

    @ForeignKey
    var owner: Student? = null

}