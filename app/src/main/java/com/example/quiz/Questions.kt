package com.example.quiz

class Questions(
    val desc: String,
    val options: List<String>,
    val answer: Int
        ) {

    init {
        println("Starting a new question object")
    }

    fun isAnswear(n:Int): Boolean {
        return answer == n
    }
}