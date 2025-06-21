package com.mb.zagabaplaylist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.data.Song
import com.mb.zagabaplaylist.databinding.ActivityAddSongBinding
import com.mb.zagabaplaylist.viewmodel.SharedViewModel
import java.util.UUID

class AddSongActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSongBinding
    private val viewModel = SharedViewModel.songViewModel
    private var isEditMode = false
    private var editingSongId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default rating label
        binding.seekBarRating.setOnSeekBarChangeListener(object :
            android.widget.SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: android.widget.SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvRatingLabel.text = "Puntuación: ${progress} ★"
            }

            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {}
        })

        // Ver si venimos en modo edición
        intent.getStringExtra("song_id")?.let { id ->
            isEditMode = true
            editingSongId = id
            binding.etTitle.setText(intent.getStringExtra("title"))
            binding.etAuthor.setText(intent.getStringExtra("author"))
            binding.seekBarRating.progress = (intent.getIntExtra("rating", 3))
            binding.tvRatingLabel.text = "Puntuación: ${binding.seekBarRating.progress} ★"
            binding.btnAdd.text = "Guardar cambios"
        }

        binding.btnAdd.setOnClickListener {
            if (!validarCampos()) return@setOnClickListener

            val id = editingSongId ?: UUID.randomUUID().toString()
            val title = binding.etTitle.text.toString()
            val author = binding.etAuthor.text.toString()
            val rating = binding.seekBarRating.progress

            val song = Song(id = id, title = title, author = author, rating = rating)

            if (isEditMode) {
                viewModel.updateSong(song)
            } else {
                viewModel.addSong(song)
            }

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
            return false
        }

        if (author.isBlank()) {
            binding.etAuthor.error = "Por favor ingrese un autor"
            Toast.makeText(this, "El autor no puede estar vacío", Toast.LENGTH_SHORT).show()
            return false
        }

        if (rating <= 0) {
            Toast.makeText(this, "Ingrese un rating para la canción", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}