package com.gts.studyplanner.student.data.repo

import com.gts.studyplanner.student.data.model.Student
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.orderBy
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.sql.language.NameAlias
import com.raizlabs.android.dbflow.sql.language.OrderBy

object StudentRepo {

    val orderByUpdatedAt = OrderBy.fromNameAlias(NameAlias.of("updated_at")).descending()

    fun getAll(): MutableList<Student> {
        return (select
                from Student::class
                orderBy orderByUpdatedAt).list
    }

}