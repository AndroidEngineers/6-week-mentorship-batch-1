package com.dinakaran.cinescope.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dinakaran.cinescope.R
import com.dinakaran.cinescope.data.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
        Column(
                modifier = modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
        ) {

                // Featured Section
                LazyRow(
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(start = 8.dp,
                                        end = 8.dp,
                                        top = 20.dp
                                )
                ) {
                        items(dummyFeatured.size) { movie ->
                                val movie = dummyFeatured[movie]
                                MovieItem(movie)
                        }
                }

                // Upcoming Section
                MovieSection(
                        title = stringResource(R.string.upcoming),
                        movies = dummyUpcoming,
                        onViewAllClick = { /* TODO Handle navigation */ }
                )

                // Popular Section
                MovieSection(
                        title = stringResource(R.string.popular),
                        movies = dummyPopular,
                        onViewAllClick = { /* TODO Handle navigation */ }
                )

                // Top Rated Section
                MovieSection(
                        title = stringResource(R.string.top_rated),
                        movies = dummyTopRated,
                        onViewAllClick = { /* TODO Handle navigation */ }
                )
        }
}


// Dummy data
val dummyUpcoming = listOf(
        Movie(1, "Movie 1", R.drawable.local_movie),
        Movie(2, "Movie 2", R.drawable.local_movie),
        Movie(3, "Movie 3", R.drawable.local_movie),
        Movie(4, "Movie 4", R.drawable.local_movie),
        Movie(5, "Movie 5", R.drawable.local_movie),
        Movie(6, "Movie 6", R.drawable.local_movie)
)

val dummyPopular = listOf(
        Movie(1, "Popular 1", R.drawable.local_movie),
        Movie(2, "Popular 2", R.drawable.local_movie),
        Movie(3, "Popular 3", R.drawable.local_movie),
        Movie(4, "Popular 4", R.drawable.local_movie),
        Movie(5, "Popular 5", R.drawable.local_movie),
        Movie(6, "Popular 6", R.drawable.local_movie)
)

val dummyTopRated = listOf(
        Movie(7, "Top 1", R.drawable.local_movie),
        Movie(8, "Top 2", R.drawable.local_movie),
        Movie(9, "Top 3", R.drawable.local_movie),
        Movie(1, "Top 4", R.drawable.local_movie),
        Movie(2, "Top 5", R.drawable.local_movie),
        Movie(3, "Top 6", R.drawable.local_movie)
)

val dummyFeatured = listOf(
        Movie(1, "Featured 1", R.drawable.local_movie),
        Movie(2, "Featured 2", R.drawable.local_movie),
        Movie(3, "Featured 3", R.drawable.local_movie),
        Movie(4, "Featured 4", R.drawable.local_movie),
        Movie(5, "Featured 5", R.drawable.local_movie),
        Movie(6, "Featured 6", R.drawable.local_movie)
)