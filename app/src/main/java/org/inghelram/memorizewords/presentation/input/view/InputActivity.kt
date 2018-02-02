package org.inghelram.memorizewords.presentation.input.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import be.sigmadelta.substratum.threading.MainThread
import be.sigmadelta.substratum.threading.ThreadExecutor
import be.sigmadelta.substratum.usecase.UseCaseFactory
import org.inghelram.memorizewords.R
import org.inghelram.memorizewords.data.database.StoreTranslationsRepository
import org.inghelram.memorizewords.domain.input.IInputPresenter
import org.inghelram.memorizewords.domain.input.IInputView
import org.inghelram.memorizewords.presentation.input.InputPresenter

/**
 * Created by pieter on 01/02/18.
 */
class InputActivity : AppCompatActivity(), IInputView {
    val repository = StoreTranslationsRepository(this)
    val inputView: IInputPresenter = InputPresenter(ThreadExecutor.INSTANCE, MainThread.INSTANCE, UseCaseFactory(), repository, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val inputText1 = findViewById<EditText>(R.id.inputtext1)
        val inputText2 = findViewById<EditText>(R.id.inputtext2)
        val saveButton = findViewById<Button>(R.id.button_save)

        saveButton.setOnClickListener { inputView.storeInput(inputText1.text.toString(), inputText2.text.toString()) }
    }

    override fun showValueStored() {
        Toast.makeText(this, "value stored", Toast.LENGTH_SHORT).show()
    }
}