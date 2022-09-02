package com.nilsnahooy.quizapp

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val questionList = Constants.getQuestions()
        setQuestion(questionList, 0)

    }

    private fun setQuestion(ql: ArrayList<Question>, i: Int) {
        val q: Question = ql[i]
        val wrapper: LinearLayoutCompat = findViewById(R.id.ll_answer_wrapper)
        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val ivFlag: ImageView = findViewById(R.id.iv_flag)
        val pbProgress: ProgressBar = findViewById(R.id.pb_progress)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val progress: Int = 100 / ql.size * (i + 1)
        val answers: ArrayList<String> = q.options
        tvQuestion.text = q.question
        ivFlag.setImageResource(q.image)
        pbProgress.progress = progress
        tvProgress.text = String.format(getString(R.string.quiz_progress), i + 1)
        for (x in answers.indices) {
            val a = answers[x]
            val tvAnswer = TextView(this)
            tvAnswer.text = a
            tvAnswer.width = LinearLayoutCompat.LayoutParams.MATCH_PARENT
            tvAnswer.gravity = Gravity.CENTER
            tvAnswer.background =
                ResourcesCompat.getDrawable(resources, R.drawable.answer_option, null)
            tvAnswer.textSize = 24f
            tvAnswer.setOnClickListener {
                Log.i("Clicked Answer", a)
            }

            wrapper.addView(tvAnswer)
        }
    }
}