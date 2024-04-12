package com.wreckingballsoftware.blackmailed.data.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BlackmailWordsDao {
    @Query("SELECT * FROM" +
            "(SELECT DISTINCT * FROM words " +
            "ORDER BY RANDOM() " +
            "LIMIT 65) " +
            "UNION " +
            "SELECT * FROM " +
            "(SELECT DISTINCT * FROM subjects " +
            "ORDER BY random() " +
            "LIMIT 5)")
    fun getBlackmailWords(): List<DBWord>
}
