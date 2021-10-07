package com.example.roomwordsample.viewmodel

import androidx.lifecycle.*
import com.example.roomwordsample.data.Word
import com.example.roomwordsample.data.WordRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    //    Using LiveData and caching what allWords returns has several benefits:
    //    - We can put an observer on the data (instead of polling for changes)
    //    and only update the UI when the data actually changes.
    //    - Repository is completely separated from the UI through the viewModel.
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /*
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}
