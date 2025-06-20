package com.mb.zagabaplaylist.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.data.Song
import com.mb.zagabaplaylist.databinding.ActivityAddSongBinding
import com.mb.zagabaplaylist.utils.SongRepository

class AddSongActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val song = Song(
                title = binding.etTitle.text.toString(),
                author = binding.etAuthor.text.toString(),
                duration = binding.etDuration.text.toString()
            )
            if (song.title.isNotBlank() && song.author.isNotBlank() && song.duration.isNotBlank()) {
                SongRepository.songs.add(song)
                startActivity(Intent(this, SongListActivity::class.java))
            }
        }
    }
}