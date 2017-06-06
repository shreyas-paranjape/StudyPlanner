package com.gts.studyplanner.student.data.model

import com.gts.studyplanner.student.data.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

@Table(name = "students", database = AppDatabase::class)
class Student : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    @Column(name = "updated_at")
    var updatedAt: Calendar = Calendar.getInstance();

//    @OneToMany(methods = arrayOf(OneToMany.Method.ALL), variableName = "tasks")
//    fun getTasks(): MutableList<Task> {
//        return (select
//                from Task::class
//                orderBy TaskRepo.orderByUpdatedAt).list
//    }

}
