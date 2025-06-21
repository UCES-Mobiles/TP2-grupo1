package com.mb.zagabaplaylist.viewmodel

import androidx.lifecycle.ViewModel
import com.mb.zagabaplaylist.data.Song


class SongViewModel : ViewModel() {
    private val _songs = mutableListOf<Song>()
    val songs: List<Song> get() = _songs

    fun addSong(song: Song) {
        _songs.add(song)
    }
}