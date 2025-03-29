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





















//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.dinakaran.cinescope.R
//import com.dinakaran.cinescope.data.model.Movie
//
//
//// Favorite Movie Item Composable
//@Composable
//fun FavoriteMovieItem(movie: Movie, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .width(130.dp)
//            .padding(8.dp)
//            .clickable { onClick() },
//        shape = RoundedCornerShape(10.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Image(
//                painter = painterResource(id = movie.poster),
//                contentDescription = movie.title,
//                modifier = Modifier
//                    .height(180.dp)
//                    .fillMaxWidth()
//            )
//            Text(
//                text = movie.title,
//                fontSize = 16.sp,
//                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
//            )
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 8.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Star,
//                    contentDescription = null,
//                    modifier = Modifier.size(16.dp),
//                    tint = MaterialTheme.colorScheme.primary
//                )
////                Text(
////                    text = movie.rating,
////                    fontSize = 14.sp,
////                    modifier = Modifier.padding(start = 4.dp)
////                )
//            }
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//// Favorites Screen
//@Composable
//fun FavoriteScreen(onMovieClick: (Movie) -> Unit = {}) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        Text(
//            text = "Favorites",
//            style = MaterialTheme.typography.titleLarge,
//            fontSize = 18.sp,
//            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
//        )
//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 130.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp),
//            contentPadding = PaddingValues(bottom = 8.dp)
//        ) {
//            items(dummyFavorites.size) { movie ->
//                val movie = dummyFavorites[movie]
//                FavoriteMovieItem(movie) {
//                    onMovieClick(movie)
//                }
//            }
//        }
//    }
//}
//
//
//
//
//// Dummy data
//
//val dummyFavorites = listOf(
//    Movie(1, "Favorite Movie 1", R.drawable.local_movie),
//    Movie(2, "Favorite Movie 2", R.drawable.local_movie),
//    Movie(3, "Favorite Movie 3", R.drawable.local_movie),
//    Movie(4, "Favorite Movie 4", R.drawable.local_movie),
//    Movie(5, "Favorite Movie 5", R.drawable.local_movie),
//    Movie(6, "Favorite Movie 6", R.drawable.local_movie)
//)
