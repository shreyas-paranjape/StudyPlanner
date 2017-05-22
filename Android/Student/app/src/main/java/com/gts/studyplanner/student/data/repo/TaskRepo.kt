package com.gts.studyplanner.student.data.repo

import com.gts.studyplanner.student.data.model.Student
import com.gts.studyplanner.student.data.model.Task
import com.gts.studyplanner.student.data.model.Task_Table
import com.raizlabs.android.dbflow.kotlinextensions.*
import com.raizlabs.android.dbflow.sql.language.NameAlias
import com.raizlabs.android.dbflow.sql.language.OrderBy

object TaskRepo {

    val orderByUpdatedAt = OrderBy.fromNameAlias(NameAlias.of("updated_at")).descending()

    fun getAll(): MutableList<Task> {
        return (select
                from Task::class
                orderBy orderByUpdatedAt).list
    }

    fun getByStudent(owner: Student): MutableList<Task> {
        return (select
                from Task::class
                where (Task_Table.owner_id eq owner.id)
                orderBy orderByUpdatedAt).list
    }
}