package org.inghelram.memorizewords.data.database

import android.content.Context
import org.inghelram.memorizewords.domain.assessment.IAssessmentRepository
import org.inghelram.memorizewords.domain.assessment.IAssessmentUseCase
import java.util.*

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
class AssessmentRepository(context: Context) : IAssessmentRepository {
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)!! //todo check this
    val random = Random()

    override fun nextAssessment(callback: IAssessmentUseCase) {
        var translation = database.translationDao().findRandomTranslation()
        if (translation == null) {
            translation = Translation(translation1 = "", translation2 = "")
        }
        callback.onTaskComplete(translation)
    }
}