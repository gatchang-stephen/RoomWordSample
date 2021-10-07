package com.example.roomwordsample.application

import android.app.Application
import com.example.roomwordsample.data.WordRepository
import com.example.roomwordsample.data.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    //    No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())

    //    Using by lazy so the database and the repository are only created when they're needed
    //    rather than when the application start
    private val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.WordDao()) }
}