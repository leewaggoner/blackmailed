package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class DBSubject(
    @PrimaryKey
    val id: Long = 0L,
    val subject: String,
)
