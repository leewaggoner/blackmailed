package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BlackmailPromptsDao {
    @Query("SELECT * FROM prompts ORDER BY RANDOM()")
    fun getBlackmailPrompts(): List<DBPrompt>
}
