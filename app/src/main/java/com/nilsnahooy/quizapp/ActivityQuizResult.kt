package com.nilsnahooy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityQuizResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val tvPlayerName: TextView = findViewById(R.id.tv_greeting)
        val tvScore: TextView = findViewById(R.id.tv_result)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        val playerName: String = intent.getStringExtra("playerName").toString()
        val score: Int = intent.getIntExtra("playerScore", 0)
        val totalQuestions: Int = intent.getIntExtra("totalQuestions", 0)

        tvPlayerName.text = String.format(getString(R.string.title_greeting), playerName)
        tvScore.text = String.format(getString(R.string.quiz_result), score, totalQuestions)

        btnFinish.setOnClickListener {
            val intentToRestart = Intent(this, MainActivity::class.java)
            startActivity(intentToRestart)
            finish()
        }
    }
}