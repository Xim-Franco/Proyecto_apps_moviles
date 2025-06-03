package com.example.proyecto.data

object HistoryRepository {
    private val history = mutableListOf<String>()

    fun getHistory(): List<String> = history

    fun addLetter(letter: String) {
        history.add(letter)
    }

    fun clearHistory() {
        history.clear()
    }
}
