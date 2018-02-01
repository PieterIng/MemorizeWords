package org.inghelram.memorizewords.data.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by pieter on 31/01/18.
 */
@Entity
data class Translation(@PrimaryKey(autoGenerate = true) val id: Long = 0,
                       @ColumnInfo val translation1: String,
                       @ColumnInfo val translation2: String,
                       @ColumnInfo val comments: String = "",
                       @ColumnInfo val imageUrl: String = "",
                       @ColumnInfo val amountCorrect: Int = 0,
                       @ColumnInfo val amountWrong: Int = 0)