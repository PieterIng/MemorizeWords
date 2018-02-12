package org.inghelram.memorizewords.data.database

import android.content.Context
import org.inghelram.memorizewords.domain.assessment.IAssessmentRepository
import org.inghelram.memorizewords.domain.assessment.IAssessmentUseCase
import org.inghelram.memorizewords.domain.input.IInputRepository
import org.inghelram.memorizewords.domain.input.IInputUseCase

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
class AssessmentRepository(context: Context) : IAssessmentRepository{
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)!! //todo check this

    override fun nextAssessment(callback: IAssessmentUseCase) {
        val translation = database.translationDao().findTranslationById(2)
        callback.onTaskComplete(translation)
    }
}