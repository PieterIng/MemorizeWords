package org.inghelram.memorizewords.domain.assessment

import be.sigmadelta.substratum.threading.Executor
import be.sigmadelta.substratum.usecase.AbstractUseCase

/**
 * Created by pieter on 01/02/18.
 */
class AssessmentUseCase(executor: Executor, val callback: IAssessmentUseCase, val repository: IAssessmentRepository) : AbstractUseCase(executor) {

    override fun run() {
       repository.nextAssessment(callback)
    }

}