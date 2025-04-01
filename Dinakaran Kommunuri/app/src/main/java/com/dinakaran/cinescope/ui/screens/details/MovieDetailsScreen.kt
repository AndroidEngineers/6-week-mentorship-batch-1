package com.dinakaran.cinescope.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinakaran.cinescope.R
import com.dinakaran.cinescope.data.model.CastMember
import com.dinakaran.cinescope.data.model.MovieDetails
import com.dinakaran.cinescope.data.model.RelatedMovie

@Preview(showBackground = true)
@Composable
fun MovieDetailsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Banner Section
        BannerDetailsSection()

        // Poster and details Section
        PosterDetailsSection()

        // Description
        Text(
            text = stringResource(id = R.string.description),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 20.dp
                )
        )
        Text(
            text = dummyMovie.description,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 4.dp
                )
        )

        // Genres
        Text(
            text = dummyMovie.genres,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 10.dp
                )
        )

        // Cast Details
        Text(
            text = stringResource(id = R.string.cast),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 10.dp
                )
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 4.dp)
        ) {
            items(dummyCast.size) { cast ->
                val cast = dummyCast[cast]
                CastItem(cast)
            }
        }

        // Related Movies
        Text(
            text = stringResource(id = R.string.related),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 10.dp
                )
        )
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    bottom = 16.dp
                )
        ) {
            items(dummyRelated.size) { movie ->
                val movie = dummyRelated[movie]
                RelatedMovieItem(movie)
            }
        }
    }
}





// Dummy data
val dummyMovie = MovieDetails(
    banner = R.drawable.local_movie,
    poster = R.drawable.local_movie,
    title = "Sample Movie",
    rating = "8.5/10",
    length = "153 minutes",
    releaseDate = "1 jan 2025",
    description = "This is a sample movie description.",
    genres = "Action, Adventure, Sci-Fi"
)

val dummyCast = listOf(
    CastMember(1, "Actor 1", R.drawable.local_movie),
    CastMember(2, "Actor 2", R.drawable.local_movie),
    CastMember(3, "Actor 3", R.drawable.local_movie),
    CastMember(4, "Actor 4", R.drawable.local_movie),
    CastMember(5, "Actor 5", R.drawable.local_movie),
    CastMember(6, "Actor 6", R.drawable.local_movie)
)

val dummyRelated = listOf(
    RelatedMovie(1, "Related 1", R.drawable.local_movie),
    RelatedMovie(2, "Related 2", R.drawable.local_movie),
    RelatedMovie(3, "Related 3", R.drawable.local_movie),
    RelatedMovie(4, "Related 4", R.drawable.local_movie),
    RelatedMovie(5, "Related 5", R.drawable.local_movie),
    RelatedMovie(6, "Related 6", R.drawable.local_movie)
)