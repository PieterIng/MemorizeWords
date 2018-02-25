package org.inghelram.memorizewords.data.database

import android.arch.persistence.room.*

/**
 * Created by pieter on 31/01/18.
 */
@Dao
interface TranslationDao {
    @Query("select * from Translation")
    fun getAllTranslations(): List<Translation>

    @Query("select * from Translation ORDER BY RANDOM() LIMIT 1")
    fun findRandomTranslation(): Translation

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTranslation(translation: Translation)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTranslation(translation: Translation)

    @Delete
    fun deleteTranslation(translation: Translation)
}