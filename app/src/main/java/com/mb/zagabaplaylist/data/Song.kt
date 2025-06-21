package com.mb.zagabaplaylist.data

import java.util.UUID

data class Song(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val author: String,
    val rating: Int,
    val genre: String,
)

