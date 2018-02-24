package org.inghelram.memorizewords.data.database

import android.content.Context
import org.inghelram.memorizewords.domain.assessment.IAssessmentRepository
import org.inghelram.memorizewords.domain.assessment.IAssessmentUseCase
import org.inghelram.memorizewords.domain.input.IInputRepository
import org.inghelram.memorizewords.domain.input.IInputUseCase
import java.util.*

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
class AssessmentRepository(context: Context) : IAssessmentRepository{
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)!! //todo check this
    val random = Random()

    override fun nextAssessment(callback: IAssessmentUseCase) {
        val numberOfEntries = database.translationDao().getAllTranslations().size
        val randomEntry = rand(1, numberOfEntries)

        val translation = database.translationDao().findTranslationById(randomEntry)
        callback.onTaskComplete(translation)
    }

    private fun rand(from: Int, to: Int) : Long {
        val test = random.nextInt(to - from) + from
        return test.toLong()
    }
}