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
import kotlin.system.exitProcess

@Suppress("UNUSED_EXPRESSION")
class Score : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val tvScore= findViewById<TextView>(R.id.tvScore)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score", 0)
        tvScore.text = "Your score: $score/12"

        val feedback = if (score >= 6) {
            "Congratulations! You pass!"
        } else {
            "Pick up a comic book gng -_-"
        }
        tvFeedback.text = feedback

        btnReview.setOnClickListener {
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", QuizActivity2.questions)
            intent.putExtra("answers", QuizActivity2.answers)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


    }
}