package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class DBWord(
    @PrimaryKey()
    val id: Long = 0L,
    val word: String,
)
