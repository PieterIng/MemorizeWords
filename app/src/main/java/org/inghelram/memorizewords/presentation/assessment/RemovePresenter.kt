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
class RemovePresenter(executor: Executor, mainThread: IMainThread, useCaseFactory: IUseCaseFactory, private val repository: IRemoveRepository, private val iRemoveView: IRemoveView) : AbstractPresenter(executor, mainThread, useCaseFactory), IRemovePresenter, IRemoveUseCase {
    lateinit var useCase: AbstractUseCase

    override fun deleteAssessment(translation: Translation) {
        useCase = useCaseFactory.getUseCaseInstance(RemoveUseCase(executor,translation, this, repository))
        useCase.execute()
    }

    override fun onTaskComplete() {
        mainThread.post(Runnable { iRemoveView.onRemoveComplete() })
    }
}