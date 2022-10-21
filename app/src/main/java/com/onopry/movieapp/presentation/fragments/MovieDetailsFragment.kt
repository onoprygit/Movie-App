package com.onopry.movieapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.onopry.movieapp.R
import com.onopry.movieapp.databinding.FragmentMovieDetailsBinding
import com.onopry.movieapp.presentation.lists.actors.CastAdapter
import com.onopry.movieapp.presentation.lists.genres.GenresAdapter
import com.onopry.movieapp.presentation.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    private val TAG = this.javaClass.simpleName

    private lateinit var binding: FragmentMovieDetailsBinding

    private val args: MovieDetailsFragmentArgs by navArgs()
    private val viewModel: MovieDetailsViewModel by viewModels()

    private lateinit var genreAdapter: GenresAdapter
    private lateinit var castAdapter: CastAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)

        viewModel.getMovieDetails(args.movieId)
        Log.e(TAG, "onViewCreated: args = ${args.movieId}")

        setUpGenreAdapter()
        setUpCastAdapter()

        viewModel.movieDetails.observe(viewLifecycleOwner) { details ->
            with(binding){
                genreAdapter.setGenreList(details.genres)
                castAdapter.setActorsList(details.cast)

                /*
                Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${actor.imageUrl}")
                .placeholder(R.drawable.poster_placeholder)
                .into(binding.actorImage)
                */

                Glide.with(this@MovieDetailsFragment)
                    .load("https://image.tmdb.org/t/p/w500${details.poster}")
                    .into(binding.movieBackgroundImage)

                movieDetailsDescription.text = details.overview
                movieTitle.text = details.title
                movieReleaseDate.text = details.moviePremiereDate.toString()
                movieAgeCertification.text = details.certification

            }
        }

    }

    private fun setUpGenreAdapter(){
        genreAdapter = GenresAdapter()
        binding.genresRecycler.adapter = genreAdapter
    }

    private fun setUpCastAdapter(){
        castAdapter = CastAdapter()
        binding.detailsCastRecycler.adapter = castAdapter
    }

}