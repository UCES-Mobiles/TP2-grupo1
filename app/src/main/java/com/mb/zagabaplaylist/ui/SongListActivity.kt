package com.mb.zagabaplaylist.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.databinding.ActivitySongListBinding
import com.mb.zagabaplaylist.databinding.ItemSongBinding
import com.mb.zagabaplaylist.viewmodel.SharedViewModel

class SongListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongListBinding
    private val viewModel = SharedViewModel.songViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inflater = LayoutInflater.from(this)

        for (song in viewModel.songs) {
            val itemBinding = ItemSongBinding.inflate(inflater, binding.containerSongs, false)
            itemBinding.tvTitle.text = song.title
            itemBinding.tvAuthor.text = song.author
            itemBinding.tvRating.text = "⭐".repeat(song.rating)
            binding.containerSongs.addView(itemBinding.root)
        }

        binding.btnGoToAdd.setOnClickListener {
            startActivity(Intent(this, AddSongActivity::class.java))
        }
    }
}
