package com.onopry.movieapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.onopry.movieapp.databinding.FragmentMovieListBinding
import com.onopry.movieapp.presentation.lists.adapters.MovieAdapter
import com.onopry.movieapp.presentation.viewmodels.MovieListViewModel
import com.onopry.movieapp.presentation.viewmodels.ViewModelsFactory

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var movieAdapter: MovieAdapter

    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, ViewModelsFactory())
            .get(MovieListViewModel::class.java)

        viewModel.moviesPreviews.observe(viewLifecycleOwner) { movies ->
            if (movies != null) {
                movieAdapter.setData(movies)
            }
        }

        movieAdapter = MovieAdapter { id ->
            Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.recyclerMovies.adapter = movieAdapter
        binding.recyclerMovies.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }
}