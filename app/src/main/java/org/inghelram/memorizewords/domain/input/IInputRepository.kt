package org.inghelram.memorizewords.domain.input

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
interface IInputRepository {
    fun storeInput(translation1: String, translation2: String, callback: IInputUseCase)
}