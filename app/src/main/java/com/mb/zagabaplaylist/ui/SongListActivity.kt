package com.mb.zagabaplaylist.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.mb.zagabaplaylist.R
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

            itemBinding.btnOptions.setOnClickListener { view ->
                val popup = PopupMenu(this, view)
                popup.menuInflater.inflate(R.menu.song_item_menu, popup.menu)

                popup.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.action_edit -> {
                            val intent = Intent(this, AddSongActivity::class.java).apply {
                                putExtra("song_id", song.id)
                                putExtra("title", song.title)
                                putExtra("author", song.author)
                                putExtra("rating", song.rating)
                            }
                            startActivity(intent)
                            true
                        }
                        R.id.action_delete -> {
                            // Remover canción y refrescar lista
                            viewModel.removeSong(song)
                            recreate() // simple forma de refrescar
                            true
                        }
                        else -> false
                    }
                }

                popup.show()
            }
        }

        binding.btnGoToAdd.setOnClickListener {
            startActivity(Intent(this, AddSongActivity::class.java))
        }
    }
}
