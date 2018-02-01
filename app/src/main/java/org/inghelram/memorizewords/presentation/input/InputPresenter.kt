package org.inghelram.memorizewords.presentation.input

import android.content.Context
import org.inghelram.memorizewords.data.database.Translation
import org.inghelram.memorizewords.data.database.TranslationsDatabase
import org.inghelram.memorizewords.presentation.input.view.IInputView

/**
 * Created by pieter on 01/02/18.
 */
class InputPresenter(context: Context) : IInputView {
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)

    override fun storeInput(translation1: String, translation2: String) {
        val translation = Translation(translation1 = translation1, translation2 = translation2)
        database.translationDao().insertTranslation(translation)
    }

}