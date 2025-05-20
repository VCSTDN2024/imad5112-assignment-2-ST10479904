//*Garanganga Kincaid code*//
package com.example.batmanflashcards

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity2 : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    // Questions that the user will be asked
    companion object {
        private val True: Boolean = true
        private val False: Boolean = false
        val questions = arrayOf(
            "Batman's true identity is Harvey Dent",
            "The first Robin is Jason Todd",
            "Batman lives in Metropolis",
            "Batman is one of the 7 original members of the Justice League",
            "The Joker murdered Batman's parents",
            "Oswald Cobblepot is The Penguin",
            "Batman calls himself Batman, because he's favourite animal is a bat",
            "Batman's most popular villain is The Joker",
            "Selina Kyle is batgirl",
            "Batman's sidekick Jason Todd grew up and took the mantle of Nightwing",
            "Nightwing is the protector of the city Bludhaven",
            "Batman holds the title of the world's greatest detective in the DC universe",
        )// The answers to the questions
        val answers = booleanArrayOf(False, False, False, True, False, True, False, True, False, False, True, True)
    }

    private var currentQuestionIndex = 0
    private var score = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz2)

        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        displayQuestion()

        btnTrue.setOnClickListener{ checkAnswer(true) }
        btnFalse.setOnClickListener{ checkAnswer(false)}

        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                tvFeedback.text = ""    // Feedback is clear
                btnTrue.isEnabled = true    // Enables the true or false buttons before answering
                btnFalse.isEnabled = true
            } else {    // Takes user to the score screen
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
        btnNext.isEnabled = false   // Disables the buttons until the questions have been answered

        }
    
    private fun displayQuestion() {
        tvQuestion.text = questions[currentQuestionIndex]
    }
    
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        
        if (userAnswer == correctAnswer) {
            tvFeedback.text = "RIGHT"
            tvFeedback.setTextColor(Color.GREEN)
            score++
        }else {
            tvFeedback.text = "WRONG"
            tvFeedback.setTextColor(Color.RED)
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }
}