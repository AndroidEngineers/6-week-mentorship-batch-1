package com.prawin.cinescope.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prawin.cinescope.R
import com.prawin.cinescope.ui.theme.darkGoldenShade
import com.prawin.cinescope.ui.theme.darkReddish
import com.prawin.cinescope.ui.theme.white

@Preview
@Composable
private fun PreviewMovieListScreen() {
    MovieListScreen()
}

@Composable
private fun MovieListScreen() {
    val searchText = rememberSaveable() { mutableStateOf("") }
    Column {
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BasicTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .height(32.dp)
            .width(OutlinedTextFieldDefaults.MinWidth),
        interactionSource = interactionSource,
        textStyle = TextStyle(fontSize = 16.sp, color = darkReddish),
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            placeholder = {
                Text(
                    text = stringResource(R.string.search_by_movie),
                    color = darkReddish,
                    modifier = Modifier.alpha(0.5f)
                )
            },
            value = text,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            interactionSource = interactionSource,
            visualTransformation = VisualTransformation.None,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 0.dp,
                bottom = 0.dp
            ),
            container = {
                Box(
                    modifier = Modifier.border(
                        color = darkReddish,
                        width = 1.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                )
            },
        )
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