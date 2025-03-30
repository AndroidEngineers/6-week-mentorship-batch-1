package com.prawin.cinescope.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Sort
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.R
import com.prawin.cinescope.custom_widgets.CustomOutlinedTextField
import com.prawin.cinescope.ui.theme.darkGoldenShade
import com.prawin.cinescope.ui.theme.darkReddish
import com.prawin.cinescope.ui.theme.white

@Preview
@Composable
private fun PreviewMovieListScreen() {
    MovieListScreen(PaddingValues(0.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(paddingValues: PaddingValues) {
    val searchText = rememberSaveable() { mutableStateOf("") }
    val sortSheetState = rememberModalBottomSheetState()
    var isSortSheetOpen = rememberSaveable { mutableStateOf(false) }
    val filterSheetState = rememberModalBottomSheetState()
    var isFilterSheetOpen = rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.padding(paddingValues)) {
        Row(Modifier.padding(8.dp)) {
            CustomOutlinedTextField(
                modifier = Modifier
                    .weight(1f),
                text = searchText.value,
                onValueChange = {
                    searchText.value = it
                },
            )
            Spacer(Modifier.width(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors(darkGoldenShade),
                modifier = Modifier
                    .size(32.dp),
                elevation = ButtonDefaults.buttonElevation(6.dp),
                contentPadding = PaddingValues(4.dp),
                onClick = {
                    //todo perform filtration
                    isFilterSheetOpen.value = true
                }) {
                Image(
                    modifier = Modifier.size(28.dp),
                    colorFilter = ColorFilter.tint(white),
                    imageVector = Icons.Rounded.FilterList,
                    contentDescription = "filter"
                )
            }
            Spacer(Modifier.width(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors(darkReddish),
                modifier = Modifier
                    .size(32.dp),
                elevation = ButtonDefaults.buttonElevation(6.dp),
                contentPadding = PaddingValues(4.dp),
                onClick = {
                    //todo perform sorting
                    isSortSheetOpen.value = true
                }) {
                Image(
                    modifier = Modifier.size(28.dp),
                    colorFilter = ColorFilter.tint(white),
                    imageVector = Icons.AutoMirrored.Rounded.Sort,
                    contentDescription = "sort"
                )
            }
        }
        MovieList(Modifier.weight(1f, fill = true))
    }
    if (isSortSheetOpen.value) {
        ModalBottomSheet(onDismissRequest = {
            isSortSheetOpen.value = false
        }, sheetState = sortSheetState) {
            SortSheetContents(isSortSheetOpen)
        }
    }
    if (isFilterSheetOpen.value) {
        ModalBottomSheet(onDismissRequest = {
            isFilterSheetOpen.value = false
        }, sheetState = filterSheetState) {
            FilterSheetContents(isFilterSheetOpen)
        }
    }
}

@Composable
private fun MovieList(modifier: Modifier) {
    LazyVerticalGrid(modifier = modifier.padding(horizontal = 4.dp), columns = GridCells.Fixed(2)) {
        items(count = 10) {
            MovieCard()
        }
    }
}

@Composable
private fun MovieCard() {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Card(modifier = Modifier.height(240.dp), elevation = CardDefaults.cardElevation(6.dp)) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.app_icon),
                contentDescription = "movie_poster",
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(darkReddish)
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Rounded.ThumbUp,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(
                        white
                    )
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "7.8 / 10",
                    color = white,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "95k Votes",
                    color = white,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 2.dp),
            text = "The Lion King (2024)",
            color = darkReddish,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
    }
}