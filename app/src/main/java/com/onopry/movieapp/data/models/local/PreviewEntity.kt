package com.onopry.movieapp.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onopry.movieapp.domain.models.MoviePreview

private const val TABLE_NAME = "movie_preview_table"

@Entity(tableName = TABLE_NAME)
data class PreviewEntity(
    @PrimaryKey
    @ColumnInfo(name = "preview_id")
    val id: Long,

    @ColumnInfo(name = "preview_title")
    val originalTitle: String,

    @ColumnInfo(name = "preview_description")
    val description: String,

    @ColumnInfo(name = "preview_rating")
    val rating: Float,

    @ColumnInfo(name = "preview_release_date")
    val releaseDate: String,

    @ColumnInfo(name = "preview_image_url")
    val imagePath: String?,

    @ColumnInfo(name = "preview_genre_id")
    val genreIds: List<Int>
) {
    fun toDomainModel() = MoviePreview(
        id = id,
        originalTitle = originalTitle,
        description = description,
        rating = rating,
        releaseDate = releaseDate,
        imagePath = imagePath,
        genreIds = genreIds
    )
}
