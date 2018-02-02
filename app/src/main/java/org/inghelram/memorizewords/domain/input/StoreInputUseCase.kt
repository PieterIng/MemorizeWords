package org.inghelram.memorizewords.domain.input

import be.sigmadelta.substratum.threading.Executor
import be.sigmadelta.substratum.usecase.AbstractUseCase

/**
 * Created by pieter on 01/02/18.
 */
class StoreInputUseCase(executor: Executor, val callback: IInputUseCase, val repository: IInputRepository, val translation1: String, val translation2: String) : AbstractUseCase(executor) {

    override fun run() {
       repository.storeInput(translation1, translation2, callback)
    }

}