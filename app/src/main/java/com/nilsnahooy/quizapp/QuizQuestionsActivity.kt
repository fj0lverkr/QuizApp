package com.nilsnahooy.quizapp

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children

class QuizQuestionsActivity : AppCompatActivity() {
    private var selectedAnswer: Int? = null
    private var correctAnswer: Int? = null
    private var currentQuestion: Int = 0
    private var totalQuestions: Int = 0
    private var correctQuestions: Int = 0
    private var isContinue: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionList = Constants.getQuestions()
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        totalQuestions = questionList.size

        btnSubmit.setOnClickListener {
            if (!isContinue) {
                if (selectedAnswer != null && correctAnswer != null) {
                    showQuestionResult()
                    if (selectedAnswer == correctAnswer) {
                        correctQuestions += 1
                    }
                    selectedAnswer = null
                    correctAnswer = null
                    isContinue = true
                    currentQuestion += 1
                    btnSubmit.text = if (currentQuestion < questionList.size-1) {
                        resources.getText(R.string.label_next)
                    }else{
                        resources.getText(R.string.label_finish)
                    }
                }
            } else {
                if(currentQuestion <= questionList.size -1) {
                    setQuestion(questionList, currentQuestion)
                } else {
                    //TODO create endgame activity and go there
                }
            }
        }

        setQuestion(questionList, currentQuestion)
    }

    private fun setQuestion(ql: ArrayList<Question>, i: Int) {
        val q: Question = ql[i]
        val wrapper: LinearLayoutCompat = findViewById(R.id.ll_answer_wrapper)
        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val ivFlag: ImageView = findViewById(R.id.iv_flag)
        val pbProgress: ProgressBar = findViewById(R.id.pb_progress)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val btnSubmit: Button = findViewById(R.id.btn_submit)
        val progress: Int = 100 / ql.size * (i + 1)
        val answers: ArrayList<String> = q.options

        isContinue = false
        correctAnswer = q.correctAnswer
        tvQuestion.text = q.question
        ivFlag.setImageResource(q.image)
        pbProgress.progress = progress
        tvProgress.text = String.format(getString(R.string.quiz_progress), i + 1, ql.size)
        wrapper.removeAllViewsInLayout()
        btnSubmit.text = resources.getText(R.string.label_answer)

        for (x in answers.indices) {
            val a = answers[x]
            val tvAnswer = TextView(this)
            tvAnswer.text = a
            tvAnswer.tag = "$x"
            tvAnswer.width = LinearLayoutCompat.LayoutParams.MATCH_PARENT
            tvAnswer.gravity = Gravity.CENTER
            tvAnswer.background =
                ResourcesCompat.getDrawable(resources, R.drawable.answer_option, null)
            tvAnswer.textSize = 24f
            tvAnswer.setTextColor(ResourcesCompat.getColor(resources, R.color.black_trans,
                null))
            tvAnswer.setOnClickListener {
                for (tv in wrapper.children) {
                    val t: TextView = tv as TextView
                    t.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.answer_option,
                            null)
                }
                val current: TextView = it as TextView
                current.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.answer_option_selected,
                        null)
                selectedAnswer = current.tag.toString().toInt()
            }
            wrapper.addView(tvAnswer)
        }
    }

    private fun showQuestionResult() {
        val wrapper: LinearLayoutCompat = findViewById(R.id.ll_answer_wrapper)

        for(child in wrapper.children) {
            val c: TextView = child as TextView
            c.setOnClickListener(null)
            when (c.tag.toString()) {
                correctAnswer.toString() -> {
                    c.setTextColor(ResourcesCompat.getColor(resources, R.color.white,
                        null))
                    c.background = ResourcesCompat.getDrawable(resources, R.drawable.answer_correct,
                        null)
                    continue
                }
                selectedAnswer.toString() -> {
                    c.setTextColor(ResourcesCompat.getColor(resources, R.color.white,
                        null))
                    c.background = ResourcesCompat.getDrawable(resources,
                        R.drawable.answer_incorrect, null)
                    continue
                }
                else -> {
                    continue
                }
            }
        }
    }
}