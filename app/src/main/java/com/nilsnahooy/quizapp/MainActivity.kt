package com.nilsnahooy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.btn_start)
        val nameField = findViewById<EditText>(R.id.input_name)
        val shakeField =
        startButton.setOnClickListener {
            if (nameField.length() == 0){ nameField.error = getString(R.string.error_name_missing)}
            else {
                val intentToQuestions = Intent(this,
                    QuizQuestionsActivity::class.java)
                startActivity(intentToQuestions)
                finish()
            }
        }
    }
}