package org.inghelram.memorizewords.domain.assessment

import org.inghelram.memorizewords.data.database.Translation

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
interface IRemoveRepository {
    fun removeAssessment(translation: Translation, callback: IRemoveUseCase)
}