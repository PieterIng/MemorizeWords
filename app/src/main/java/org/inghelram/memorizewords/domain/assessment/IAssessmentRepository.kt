package org.inghelram.memorizewords.domain.assessment

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
interface IAssessmentRepository {
    fun nextAssessment(callback: IAssessmentUseCase)
}