package com.onopry.movieapp.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onopry.movieapp.domain.models.Genre
import com.squareup.moshi.Json

private const val TABLE_NAME = "genre_table"

@Entity(tableName = TABLE_NAME)
data class GenreEntity(
    @PrimaryKey
    val id: Int,
    val name: String
){
    fun toDomainModel() = Genre(id = id, name = name)
}
