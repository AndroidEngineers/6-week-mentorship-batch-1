package com.dinakaran.cinescope.ui.screens.favourite


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinakaran.cinescope.R
import com.dinakaran.cinescope.data.model.Movie


// Dummy favorite movies data
val dummyFavorites = listOf(
    Movie(1, "Favorite Movie 1", R.drawable.local_movie),
    Movie(2, "Favorite Movie 2", R.drawable.local_movie),
    Movie(3, "Favorite Movie 3", R.drawable.local_movie),
    Movie(4, "Favorite Movie 4", R.drawable.local_movie),
    Movie(5, "Favorite Movie 5", R.drawable.local_movie),
    Movie(6, "Favorite Movie 6", R.drawable.local_movie)
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            FavouriteTitleBar()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
        ) {
            items(dummyFavorites) { movie ->
                FavoriteMovieItem(movie)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}