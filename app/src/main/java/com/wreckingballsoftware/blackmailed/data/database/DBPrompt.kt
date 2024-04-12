package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prompts")
data class DBPrompt(
    @PrimaryKey
    val id: Long = 0L,
    val prompt: String,
)
