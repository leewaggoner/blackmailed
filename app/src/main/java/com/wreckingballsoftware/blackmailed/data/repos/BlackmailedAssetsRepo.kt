package com.wreckingballsoftware.blackmailed.data.repos

import com.wreckingballsoftware.blackmailed.data.database.BlackmailPromptsDao
import com.wreckingballsoftware.blackmailed.data.database.BlackmailWordsDao
import com.wreckingballsoftware.blackmailed.data.database.DBPrompt
import com.wreckingballsoftware.blackmailed.data.database.DBWord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BlackmailedAssetsRepo(
    private val blackmailWordsDao: BlackmailWordsDao,
    private val blackmailPromptsDao: BlackmailPromptsDao
) {
    private var promptIndex = 0
    private var blackmailPrompts: List<DBPrompt>? = null

    suspend fun getBlackmailWords(): List<DBWord> = withContext(Dispatchers.IO) {
        blackmailWordsDao.getBlackmailWords()
    }

    fun getNextPrompt(): DBPrompt {
        var result = DBPrompt(prompt = "")
        blackmailPrompts?.let { prompts ->
            if (promptIndex >= prompts.size) {
                promptIndex = 0
            }
            result = prompts[promptIndex++]
        }
        return result
    }

    suspend fun getBlackmailPrompts() {
        val prompts = fetchBlackmailPrompts()
        blackmailPrompts = prompts
    }

    private suspend fun fetchBlackmailPrompts(): List<DBPrompt> = withContext(Dispatchers.IO) {
        blackmailPromptsDao.getBlackmailPrompts()
    }
}
