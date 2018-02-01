package org.inghelram.memorizewords.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


/**
 * Created by pieter on 31/01/18.
 */
@Database(entities = arrayOf(Translation::class), version = 1)
abstract class TranslationsDatabase : RoomDatabase() {
    public abstract fun translationDao(): TranslationDao

    //todo: as Google says: use singleton pattern as each RoomDatabase instance is fairly expensive
    companion object {
        private lateinit var INSTANCE: TranslationsDatabase

        fun getInstance(context: Context): TranslationsDatabase {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    TranslationsDatabase::class.java, "translations.db").build();
            return INSTANCE
        }

    }
}