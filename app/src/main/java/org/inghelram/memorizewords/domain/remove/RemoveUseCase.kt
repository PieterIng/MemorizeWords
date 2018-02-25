package org.inghelram.memorizewords.domain.assessment

import be.sigmadelta.substratum.threading.Executor
import be.sigmadelta.substratum.usecase.AbstractUseCase
import org.inghelram.memorizewords.data.database.Translation

/**
 * Created by pieter on 01/02/18.
 */
class RemoveUseCase(executor: Executor, val translation: Translation, val callback: IRemoveUseCase, val repository: IRemoveRepository) : AbstractUseCase(executor) {

    override fun run() {
       repository.removeAssessment(translation, callback)
    }

}