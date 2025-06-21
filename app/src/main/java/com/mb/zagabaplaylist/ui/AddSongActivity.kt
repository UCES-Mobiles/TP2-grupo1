package com.mb.zagabaplaylist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
                binding.tvRatingLabel.text = "Puntuación: $progress ★"
            }

            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {}
        })

        binding.btnAdd.setOnClickListener {
            if (!validarCampos()) return@setOnClickListener

            val title = binding.etTitle.text.toString()
            val author = binding.etAuthor.text.toString()
            val rating = binding.seekBarRating.progress
            val song = Song(title, author,rating)

            viewModel.addSong(song)
            startActivity(Intent(this, SongListActivity::class.java))

        }

        binding.btnGoToList.setOnClickListener {
            startActivity(Intent(this, SongListActivity::class.java))
        }
    }

    private fun validarCampos(): Boolean {
        val title = binding.etTitle.text.toString()
        val author = binding.etAuthor.text.toString()
        val rating = binding.seekBarRating.progress

        if (title.isBlank()) {
            binding.etTitle.error = "Por favor ingrese un título"
            Toast.makeText(this, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
            binding.etTitle.requestFocus()
            return false
        }

        if (author.isBlank()) {
            binding.etAuthor.error = "Por favor ingrese un autor"
            Toast.makeText(this, "El autor no puede estar vacío", Toast.LENGTH_SHORT).show()
            binding.etAuthor.requestFocus()
            return false
        }

        if (rating <= 0) {
            Toast.makeText(this, "Ingrese un rating para la canción", Toast.LENGTH_SHORT).show()
            binding.seekBarRating.requestFocus()
            return false
        }

        if (rating <= 0) {
            Toast.makeText(this, "Ingrese un rating para la canción", Toast.LENGTH_SHORT).show()
            binding.seekBarRating.requestFocus()
            return false
        }

        return true
    }
}