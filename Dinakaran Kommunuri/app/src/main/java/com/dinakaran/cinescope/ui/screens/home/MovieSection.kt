package com.dinakaran.cinescope.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinakaran.cinescope.R
import com.dinakaran.cinescope.data.model.Movie


@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>,
    onViewAllClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top =  10.dp,
                bottom = if (title == stringResource(R.string.top_rated)) 16.dp else 0.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 18.sp
            )
            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.titleSmall,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { onViewAllClick() }
                    .padding(4.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top =  4.dp
                )
        ) {
            items(movies.size) { index ->
                val movie = movies[index]
                MovieItem(movie)
            }
        }
    }
}