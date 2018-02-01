package org.inghelram.memorizewords.presentation.input.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import org.inghelram.memorizewords.R
import org.inghelram.memorizewords.presentation.input.InputPresenter

/**
 * Created by pieter on 01/02/18.
 */
class MainActivity : AppCompatActivity() {
    val inputView: IInputView = InputPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val inputText1 = findViewById<EditText>(R.id.inputtext1)
        val inputText2 = findViewById<EditText>(R.id.inputtext2)
        val saveButton = findViewById<Button>(R.id.button_save)

        saveButton.setOnClickListener { inputView.storeInput(inputText1.text.toString(), inputText2.text.toString()) }
    }
}