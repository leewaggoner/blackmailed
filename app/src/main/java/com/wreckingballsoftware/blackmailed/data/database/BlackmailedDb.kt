package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DBWord::class,
        DBSubject::class,
        DBPrompt::class,
    ],
    version = 3,
    exportSchema = false
)
abstract class BlackmailedDb : RoomDatabase() {
    abstract fun getBlackmailWordsDao(): BlackmailWordsDao
    abstract fun getBlackmailPromptsDao(): BlackmailPromptsDao
}
