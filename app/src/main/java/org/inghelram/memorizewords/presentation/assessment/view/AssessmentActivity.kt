package org.inghelram.memorizewords.presentation.assessment.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import be.sigmadelta.substratum.threading.MainThread
import be.sigmadelta.substratum.threading.ThreadExecutor
import be.sigmadelta.substratum.usecase.UseCaseFactory
import org.inghelram.memorizewords.R
import org.inghelram.memorizewords.data.database.AssessmentRepository
import org.inghelram.memorizewords.data.database.StoreTranslationsRepository
import org.inghelram.memorizewords.data.database.Translation
import org.inghelram.memorizewords.domain.assessment.IAssessmentPresenter
import org.inghelram.memorizewords.domain.assessment.IAssessmentView
import org.inghelram.memorizewords.presentation.assessment.AssessmentPresenter
import org.inghelram.memorizewords.presentation.input.InputPresenter

/**
 * Created by pieter on 12/02/18.
 */
class AssessmentActivity : AppCompatActivity(), IAssessmentView {
    lateinit var repository: AssessmentRepository
    lateinit var assessmentView: IAssessmentPresenter

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assessment)

        repository = AssessmentRepository(this)
        assessmentView = AssessmentPresenter(ThreadExecutor.INSTANCE, MainThread.INSTANCE, UseCaseFactory(), repository, this)

        val nextButton = findViewById<Button>(R.id.button_next)
        nextButton.setOnClickListener { assessmentView.nextAssessment() }
    }

    override fun showTranslation(translation: Translation) {
        findViewById<TextView>(R.id.tv_translation1).setText(translation.translation1)
        findViewById<TextView>(R.id.tv_translation2).setText(translation.translation2)
    }
}