//*Garanganga Kincaid code*//
package com.example.batmanflashcards

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private var StringBuilder.text: String
    get() = Unit.toString()
    set(value) {}

class Review : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val reviewTv = findViewById<TextView>(R.id.reviewTv)
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append("   Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewTv.text = reviewText.toString()
        }else {
            reviewTv.text= "Error loading review data."
        }

        btnRestart.setOnClickListener {
            startActivity(Intent(this, QuizActivity2::class.java))
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }


    }
}