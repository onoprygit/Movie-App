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

        viewModel.movieDetails.observe(viewLifecycleOwner) { state ->
            with(state) {
                hideLoadingProgress()
                if (data != null) {
                    with(binding) {
                        genreAdapter.setGenreList(data.genres)
                        castAdapter.setActorsList(data.cast)

                        Glide.with(this@MovieDetailsFragment)
                            .load("https://image.tmdb.org/t/p/w500${data.poster}")
                            .into(binding.movieBackgroundImage)

                        movieDetailsDescription.text = data.overview
                        movieTitle.text = data.title
                        movieReleaseDate.text = data.moviePremiereDate.toString()
                        movieAgeCertification.text = data.certification
                    }
                }
                if (errorMessage.isNotBlank()) onError(errorMessage)
                if (isLoading) showLoadingProgress()
            }
        }
    }

    private fun setUpGenreAdapter() {
        genreAdapter = GenresAdapter()
        binding.genresRecycler.adapter = genreAdapter
    }

    private fun setUpCastAdapter() {
        castAdapter = CastAdapter()
        binding.detailsCastRecycler.adapter = castAdapter
    }

    private fun hideContent() {
        binding.detailsCastRecycler.visibility = View.GONE
        binding.movieDetailsContent.visibility = View.GONE
    }

    private fun showContent() {
        binding.detailsCastRecycler.visibility = View.VISIBLE
        binding.movieDetailsContent.visibility = View.VISIBLE
    }

    private fun showLoadingProgress() {
        hideContent()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoadingProgress() {
        binding.progressBar.visibility = View.GONE
        showContent()
    }

    private fun onError(message: String) {
        hideContent()
        binding.errorMessage.text = message
        binding.errorMessage.visibility = View.VISIBLE
    }
}