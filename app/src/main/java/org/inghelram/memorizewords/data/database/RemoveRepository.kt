package org.inghelram.memorizewords.data.database

import android.content.Context
import org.inghelram.memorizewords.domain.assessment.IAssessmentUseCase
import org.inghelram.memorizewords.domain.assessment.IRemoveRepository
import org.inghelram.memorizewords.domain.assessment.IRemoveUseCase
import java.util.*

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
class RemoveRepository(context: Context) : IRemoveRepository {
    val database: TranslationsDatabase = TranslationsDatabase.getInstance(context)!! //todo check this
    val random = Random()

    override fun removeAssessment(translation: Translation, callback: IRemoveUseCase) {
        database.translationDao().deleteTranslation(translation)
        callback.onTaskComplete()
    }
}