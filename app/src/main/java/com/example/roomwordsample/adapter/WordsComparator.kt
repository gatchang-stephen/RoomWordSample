package com.example.roomwordsample.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.roomwordsample.data.Word

class WordsComparator : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }

}