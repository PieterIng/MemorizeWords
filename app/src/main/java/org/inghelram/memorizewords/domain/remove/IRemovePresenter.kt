package org.inghelram.memorizewords.domain.assessment

import org.inghelram.memorizewords.data.database.Translation

/**
 * Created by pieter on 12/02/18.
 */
interface IRemovePresenter {
    fun deleteAssessment(translation: Translation)
}