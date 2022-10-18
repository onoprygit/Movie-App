package com.onopry.movieapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.onopry.movieapp.R
import com.onopry.movieapp.databinding.FragmentMovieDetailsBinding
import com.onopry.movieapp.databinding.FragmentMovieListBinding
import com.onopry.movieapp.presentation.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    private val TAG = this.javaClass.simpleName

    private lateinit var binding: FragmentMovieDetailsBinding
    private val args: MovieDetailsFragmentArgs by navArgs()
    private val viewModel: MovieDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)

        viewModel.getMovieDetails(args.movieId)
        Log.e(TAG, "onViewCreated: args = ${args.movieId}")

        viewModel.movieDetails.observe(viewLifecycleOwner) { details ->
            with(binding){
                movieDetailsDescription.text = details.overview
                movieTitle.text = details.title
                movieReleaseDate.text = details.moviePremiereDate.toString()
                movieAgeCertification.text = details.certification

            }
        }

    }

}