package org.inghelram.memorizewords.presentation.input

import be.sigmadelta.substratum.presenter.AbstractPresenter
import be.sigmadelta.substratum.threading.Executor
import be.sigmadelta.substratum.threading.IMainThread
import be.sigmadelta.substratum.usecase.AbstractUseCase
import be.sigmadelta.substratum.usecase.IUseCaseFactory
import org.inghelram.memorizewords.domain.input.*

/**
 * Created by pieter on 01/02/18.
 */
class InputPresenter(executor: Executor, mainThread: IMainThread, useCaseFactory: IUseCaseFactory, private val repository: IInputRepository, private val iInputView: IInputView) : AbstractPresenter(executor, mainThread, useCaseFactory), IInputPresenter, IInputUseCase {
    lateinit var useCase : AbstractUseCase

    override fun storeInput(translation1: String, translation2: String) {
        useCase = useCaseFactory.getUseCaseInstance(StoreInputUseCase(executor, this, repository, translation1, translation2))
        useCase.execute()
    }

    override fun onTaskComplete(numberOfEntries: Int) {
        mainThread.post(Runnable { iInputView.showValueStored(numberOfEntries) })
    }

}