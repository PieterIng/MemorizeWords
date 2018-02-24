package org.inghelram.memorizewords.domain.input

import be.sigmadelta.substratum.threading.IMainThread

/**
 * Created by PIH9RX2 on 2/02/2018.
 */
interface IInputView {
    fun showValueStored(numberOfEntries: Int)
}