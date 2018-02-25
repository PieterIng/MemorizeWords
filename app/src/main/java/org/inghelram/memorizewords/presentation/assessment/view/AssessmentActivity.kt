package org.inghelram.memorizewords.presentation.assessment.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import be.sigmadelta.substratum.threading.MainThread
import be.sigmadelta.substratum.threading.ThreadExecutor
import be.sigmadelta.substratum.usecase.UseCaseFactory
import org.inghelram.memorizewords.R
import org.inghelram.memorizewords.data.database.AssessmentRepository
import org.inghelram.memorizewords.data.database.RemoveRepository
import org.inghelram.memorizewords.data.database.Translation
import org.inghelram.memorizewords.domain.assessment.IAssessmentPresenter
import org.inghelram.memorizewords.domain.assessment.IAssessmentView
import org.inghelram.memorizewords.domain.assessment.IRemovePresenter
import org.inghelram.memorizewords.domain.assessment.IRemoveView
import org.inghelram.memorizewords.presentation.assessment.AssessmentPresenter
import org.inghelram.memorizewords.presentation.assessment.RemovePresenter
import org.inghelram.memorizewords.presentation.input.view.InputActivity

/**
 * Created by pieter on 12/02/18.
 */
class AssessmentActivity : AppCompatActivity(), IAssessmentView, IRemoveView {
    lateinit var assessmentRepository: AssessmentRepository
    lateinit var assessmentView: IAssessmentPresenter
    lateinit var removeRepository: RemoveRepository
    lateinit var removeView: IRemovePresenter
    var translation = Translation(translation1 = "", translation2 = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assessment)

        assessmentRepository = AssessmentRepository(this)
        assessmentView = AssessmentPresenter(ThreadExecutor.INSTANCE, MainThread.INSTANCE, UseCaseFactory(), assessmentRepository, this)
        removeRepository = RemoveRepository(this)
        removeView = RemovePresenter(ThreadExecutor.INSTANCE, MainThread.INSTANCE, UseCaseFactory(), removeRepository, this)

        val nextButton = findViewById<Button>(R.id.button_next)
        nextButton.setOnClickListener { assessmentView.nextAssessment() }

        val deleteButton = findViewById<Button>(R.id.button_delete)
        deleteButton.setOnClickListener{ removeView.deleteAssessment(translation) }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { navigateAway() }

        assessmentView.nextAssessment()
    }

    fun navigateAway() {
        intent = Intent(this, InputActivity::class.java)
        startActivity(intent)
    }

    override fun onRemoveComplete() {
        Toast.makeText(this, "item removed", Toast.LENGTH_SHORT).show()
        assessmentView.nextAssessment()
    }

    override fun showTranslation(translation: Translation) {
        this.translation = translation
        findViewById<TextView>(R.id.tv_translation1).setText(translation.translation1)
        findViewById<TextView>(R.id.tv_translation2).setText(translation.translation2)
    }
}