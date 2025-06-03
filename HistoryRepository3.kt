package com.example.proyecto.data

object HistoryRepository {
    private var historyList = mutableListOf<String>()

    fun getHistory(): List<String> {
        return historyList
    }

    fun addItem(item: String) {
        historyList.add(item)
    }

    fun clearHistory() {
        historyList.clear()
    }

    fun setHistory(newList: List<String>) {
        historyList = newList.toMutableList()
    }
}
