package com.mb.zagabaplaylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.databinding.ActivitySongListBinding
import com.mb.zagabaplaylist.databinding.ItemSongBinding
import com.mb.zagabaplaylist.utils.SongRepository

class SongListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inflater = LayoutInflater.from(this)

        for (song in SongRepository.songs) {
            val itemBinding = ItemSongBinding.inflate(inflater, binding.containerSongs, false)
            itemBinding.tvTitle.text = song.title
            itemBinding.tvAuthor.text = song.author
            itemBinding.tvDuration.text = song.duration
            binding.containerSongs.addView(itemBinding.root)
        }
    }
}