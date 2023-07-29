package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the buttons
        val aBtn = findViewById<Button>(R.id.aBtn) // A is answer 0
        val bBtn = findViewById<Button>(R.id.bBtn) // B is answer 1
        val cBtn = findViewById<Button>(R.id.cBtn) // C is answer 2
        var questionText = findViewById<TextView>(R.id.questionText)
        var listOptions = findViewById<LinearLayout>(R.id.listOptions)
        var textView = findViewById<TextView>(R.id.clone)

        // Initialize the questions
        var qCount = 0
        val questionsList: List<Questions> = listOf(
            Questions("What is an animal?", listOf("Cat", "Plane", "Car"), 0),
            Questions("What is a object?", listOf("Men", "Women", "Rock"), 2),
            Questions("What can wash clothes?", listOf("Toilet", "Oven", "Washing Machine"), 2),
            Questions("Instagram is for?", listOf("Gallery Scrolling", "Addiction Feeding", "Socializing"), 1)
        )

        // Add the first question to the screen
        fun loadQuestions() {

            if (qCount < questionsList.size) {
                questionText.text = questionsList[qCount].desc

                // Clear the options
                listOptions.removeAllViews()

                // Iterate through the options
                var i = 1
                for (o in questionsList[qCount].options) {
                    var option = TextView(this)
                    var op: String = ""
                    when(i) {
                        1 -> op = "A"
                        2 -> op = "B"
                        3 -> op = "C"
                    }
                    option.setText("$op - $o")
                    option.id = i

                    // Add the options to the screen
                    listOptions.addView(option)
                    i++
                }
            } else {
                android.widget.Toast.makeText(this, "YAY!!! You've completed everything!", android.widget.Toast.LENGTH_SHORT).show()
            }

        }
        loadQuestions() // Load a question on view load

        // Listen for when one of the buttons are pressed
        aBtn.setOnClickListener {
            if (qCount < questionsList.size)
                if (0 == questionsList[qCount].answer) {
                    qCount++
                    loadQuestions()
                } else {
                    android.widget.Toast.makeText(this, "Wrong option", android.widget.Toast.LENGTH_SHORT).show()
                }
        }
        bBtn.setOnClickListener {
            if (qCount < questionsList.size)
                if (1 == questionsList[qCount].answer) {
                    qCount++
                    loadQuestions()
                } else {
                    android.widget.Toast.makeText(this, "Wrong option", android.widget.Toast.LENGTH_SHORT).show()
                }
        }
        cBtn.setOnClickListener {
            if (qCount < questionsList.size)
                if (2 == questionsList[qCount].answer) {
                    qCount++
                    loadQuestions()
                } else {
                    android.widget.Toast.makeText(this, "Wrong option", android.widget.Toast.LENGTH_SHORT).show()
                }
        }

    }
}