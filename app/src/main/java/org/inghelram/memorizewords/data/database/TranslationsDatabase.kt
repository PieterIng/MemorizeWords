package org.inghelram.memorizewords.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


/**
 * Created by pieter on 31/01/18.
 */
@Database(entities = arrayOf(Translation::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun translationDao(): TranslationDao
}