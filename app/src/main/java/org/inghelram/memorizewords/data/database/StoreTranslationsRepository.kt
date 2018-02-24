package org.inghelram.memorizewords.data.database

import android.content.Context
import org.inghelram.memorizewords.domain.input.IInputRepository
import org.inghelram.memorizewords.domain.input.IInputUseCase

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
class StoreTranslationsRepository(context: Context) : IInputRepository {
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)!! //todo check this

    override fun storeInput(translation1: String, translation2: String, callback: IInputUseCase) {
        val translation = Translation(translation1 = translation1, translation2 = translation2)
        database.translationDao().insertTranslation(translation)

        val numberOfEntries = database.translationDao().getAllTranslations().size
        callback.onTaskComplete(numberOfEntries)
    }
}