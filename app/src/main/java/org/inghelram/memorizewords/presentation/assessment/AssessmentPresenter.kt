package org.inghelram.memorizewords.presentation.assessment

import be.sigmadelta.substratum.presenter.AbstractPresenter
import be.sigmadelta.substratum.threading.Executor
import be.sigmadelta.substratum.threading.IMainThread
import be.sigmadelta.substratum.usecase.AbstractUseCase
import be.sigmadelta.substratum.usecase.IUseCaseFactory
import org.inghelram.memorizewords.data.database.Translation
import org.inghelram.memorizewords.domain.assessment.*

/**
 * Created by pieter on 12/02/18.
 */
class AssessmentPresenter(executor: Executor, mainThread: IMainThread, useCaseFactory: IUseCaseFactory, private val repository: IAssessmentRepository, private val iAssessmentView: IAssessmentView) : AbstractPresenter(executor, mainThread, useCaseFactory), IAssessmentPresenter, IAssessmentUseCase {
    lateinit var useCase: AbstractUseCase

    override fun nextAssessment() {
        useCase = useCaseFactory.getUseCaseInstance(AssessmentUseCase(executor, this, repository))
        useCase.execute()

    }

    override fun onTaskComplete(translation: Translation) {
        mainThread.post(Runnable { iAssessmentView.showTranslation(translation) })
    }
}