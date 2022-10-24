package com.onopry.movieapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.onopry.movieapp.databinding.FragmentMovieListBinding
import com.onopry.movieapp.presentation.lists.moviespreviews.MovieAdapter
import com.onopry.movieapp.presentation.viewmodels.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var movieAdapter: MovieAdapter

    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

        viewModel.moviePreviewStatus.observe(viewLifecycleOwner) { status ->
            with(status){
                hideLoadingProgress()
                movieAdapter.setData(data)

                if (message.isNotBlank()) onError(message)
                if (isLoading) showLoadingProgress()
            }
        }

        //        viewModel.moviesPreviews.observe(viewLifecycleOwner) { movies ->
        //            if (movies != null) {
        //                movieAdapter.setData(movies)
        //            }
        //        }

        movieAdapter = MovieAdapter { id ->
            Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()
            //            val action = MovieDetailsFragmentDirections.
            val directions =
                MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(movieId = id)
            findNavController().navigate(directions)
        }

        binding.recyclerMovies.adapter = movieAdapter
        binding.recyclerMovies.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }

    private fun hideContent() {
        binding.recyclerMovies.visibility = View.INVISIBLE
    }

    private fun showContent() {
        binding.recyclerMovies.visibility = View.VISIBLE
    }

    private fun showLoadingProgress() {
        hideContent()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoadingProgress() {
        binding.progressBar.visibility = View.GONE
        showContent()
    }

    private fun onError(message: String){
        hideContent()
        binding.errorMessage.text = message
        binding.errorMessage.visibility = View.VISIBLE
    }
}