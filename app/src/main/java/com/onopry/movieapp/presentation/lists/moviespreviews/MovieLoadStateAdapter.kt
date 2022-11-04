package com.onopry.movieapp.presentation.lists.moviespreviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.onopry.movieapp.databinding.LoadStatePartBinding

typealias TryAgainAction = () -> Unit

class MovieLoadStateAdapter(
    private val tryAgain: TryAgainAction
) : LoadStateAdapter<MovieLoadStateAdapter.MovieLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: MovieLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MovieLoadStateViewHolder {
        val binding =
            LoadStatePartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieLoadStateViewHolder(binding, tryAgain)
    }


    class MovieLoadStateViewHolder(
        private val binding: LoadStatePartBinding,
        private val tryAgain: TryAgainAction,
        private val swipeRefreshLayout: SwipeRefreshLayout? = null
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.tryAgainButton.setOnClickListener { tryAgain() }
        }

        fun bind(loadState: LoadState) = with(binding) {
            messageTextView.isVisible = loadState is LoadState.Error
            tryAgainButton.isVisible = loadState is LoadState.Error
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.isRefreshing = loadState is LoadState.NotLoading
                progressBar.isVisible = false
            } else
                progressBar.isVisible = loadState is LoadState.Loading
        }
    }
}