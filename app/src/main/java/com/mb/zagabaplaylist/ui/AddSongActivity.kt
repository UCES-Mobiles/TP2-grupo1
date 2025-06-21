package com.mb.zagabaplaylist.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.data.Song
import com.mb.zagabaplaylist.databinding.ActivityAddSongBinding
import com.mb.zagabaplaylist.viewmodel.SharedViewModel

class AddSongActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSongBinding
    private val viewModel = SharedViewModel.songViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekBarRating.setOnSeekBarChangeListener(object :
            android.widget.SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: android.widget.SeekBar?, progress: Int, fromUser: Boolean) {
                val rating = progress + 1
                binding.tvRatingLabel.text = "Puntuación: $rating ★"
            }

            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {}
        })

        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val author = binding.etAuthor.text.toString()
            val duration = binding.etDuration.text.toString()
            val rating = binding.seekBarRating.progress + 1

            if (title.isNotBlank() && author.isNotBlank() && duration.isNotBlank()) {
                val song = Song(title, author, duration, rating)
                viewModel.addSong(song)
                startActivity(Intent(this, SongListActivity::class.java))
            }
        }

        binding.btnGoToList.setOnClickListener {
            startActivity(Intent(this, SongListActivity::class.java))
        }
    }
}