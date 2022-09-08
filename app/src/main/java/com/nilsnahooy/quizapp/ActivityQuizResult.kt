package com.nilsnahooy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class ActivityQuizResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val tvPlayerName: TextView = findViewById(R.id.tv_greeting)
        val tvScore: TextView = findViewById(R.id.tv_result)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        val ivTrophy: ImageView = findViewById(R.id.iv_trophy)
        val playerName: String = intent.getStringExtra("playerName").toString()
        val score: Int = intent.getIntExtra("playerScore", 0)
        val totalQuestions: Int = intent.getIntExtra("totalQuestions", 0)
        val totalScore: Double = totalQuestions.toDouble() / score.toDouble()
        var greeting = "congrats"

        if(totalScore == 1.0) {
            ivTrophy.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.star))
        } else if (totalScore > 1 && totalScore <= 2.0) {
            ivTrophy.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.star_half))
            greeting = "well done"
        } else {
            ivTrophy.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.thumb_down))
            greeting = "try again"
        }

        tvPlayerName.text = String.format(getString(R.string.title_greeting), greeting, playerName)
        tvScore.text = String.format(getString(R.string.quiz_result), score, totalQuestions)

        btnFinish.setOnClickListener {
            val intentToRestart = Intent(this, MainActivity::class.java)
            startActivity(intentToRestart)
            finish()
        }
    }
}