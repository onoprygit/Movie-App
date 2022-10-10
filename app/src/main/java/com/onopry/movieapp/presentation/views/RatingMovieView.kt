package com.onopry.movieapp.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.onopry.movieapp.R
import com.onopry.movieapp.databinding.MovieRatingViewBinding

class RatingMovieView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
): LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    private val binding = MovieRatingViewBinding.bind(this)

    private val starEmpty = R.drawable.ic_empty_star
    private val starFilled = R.drawable.ic_filled_star

    private var movieRating: Int = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.movie_rating_view, this, true)
    }

    fun setMovieRating(rating: Int){
        movieRating = rating
        drawMovieRating()
    }

    private fun drawMovieRating(){
        when(movieRating) {
            0 -> {
                binding.star1.setImageResource(starEmpty)
                binding.star2.setImageResource(starEmpty)
                binding.star3.setImageResource(starEmpty)
                binding.star4.setImageResource(starEmpty)
                binding.star5.setImageResource(starEmpty)
            }
            1 -> {
                binding.star1.setImageResource(starFilled)
                binding.star2.setImageResource(starEmpty)
                binding.star3.setImageResource(starEmpty)
                binding.star4.setImageResource(starEmpty)
                binding.star5.setImageResource(starEmpty)
            }
            2 -> {
                binding.star1.setImageResource(starFilled)
                binding.star2.setImageResource(starFilled)
                binding.star3.setImageResource(starEmpty)
                binding.star4.setImageResource(starEmpty)
                binding.star5.setImageResource(starEmpty)
            }
            3 -> {
                binding.star1.setImageResource(starFilled)
                binding.star2.setImageResource(starFilled)
                binding.star3.setImageResource(starFilled)
                binding.star4.setImageResource(starEmpty)
                binding.star5.setImageResource(starEmpty)
            }
            4 -> {
                binding.star1.setImageResource(starFilled)
                binding.star2.setImageResource(starFilled)
                binding.star3.setImageResource(starFilled)
                binding.star4.setImageResource(starFilled)
                binding.star5.setImageResource(starEmpty)
            }
            5 -> {
                binding.star1.setImageResource(starFilled)
                binding.star2.setImageResource(starFilled)
                binding.star3.setImageResource(starFilled)
                binding.star4.setImageResource(starFilled)
                binding.star5.setImageResource(starFilled)
            }
        }
    }

}