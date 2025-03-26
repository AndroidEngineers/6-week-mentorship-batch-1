package com.prawin.cinescope.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prawin.cinescope.R
import com.prawin.cinescope.model.Genre
import com.prawin.cinescope.ui.theme.brightGold
import com.prawin.cinescope.ui.theme.darkGold
import com.prawin.cinescope.ui.theme.darkGoldenShade
import com.prawin.cinescope.ui.theme.darkRed
import com.prawin.cinescope.ui.theme.darkReddish
import com.prawin.cinescope.ui.theme.lightGraySubtitle
import com.prawin.cinescope.ui.theme.white

val genreList = listOf<Genre>(
    Genre(id = 1, name = "action"),
    Genre(id = 2, name = "adventure"),
    Genre(id = 3, name = "comedy"),
    Genre(id = 4, name = "drama"),
    Genre(id = 5, name = "fantasy"),
    Genre(id = 6, name = "horror"),
    Genre(id = 7, name = "musicals"),
    Genre(id = 8, name = "mystery"),
    Genre(id = 9, name = "science fiction"),
    Genre(id = 10, name = "sports"),
)

@Preview
@Composable
private fun MovieDetailsPreview() {
    Column {
        MovieHeader()
        MovieOverview(popularity = 5f)
        MovieProduction(modifier = Modifier.weight(1f))
        BottomButtons()
    }
}

@Composable
fun MovieDetails(paddingValues: PaddingValues) {
    Column {
        MovieHeader()
        MovieOverview(popularity = 5f)
        MovieProduction(modifier = Modifier.weight(1f))
        BottomButtons()
    }
}

@Composable
fun MovieHeader() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .weight(0.4f)
                .clip(RoundedCornerShape(8.dp)),
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "movie_poster"
        )
        Spacer(Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(0.6f)
                .wrapContentHeight()
        ) {
            Text(text = "The Lion King", style = MaterialTheme.typography.titleMedium)
            Text(text = "Released On : dd/MM/yyyy", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Genres",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
            LazyRow { items(genreList) { Genres(it) } }
            Button(
                onClick = {
                    //todo add to favourites
                },
                colors = ButtonDefaults.buttonColors(darkGoldenShade),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Add To Favourites")
            }
        }
    }
}

@Composable
fun MovieOverview(modifier: Modifier = Modifier, popularity: Float) {
    Column(
        modifier
            .padding(8.dp)
    ) {
        Text(text = stringResource(R.string.overview), style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(4.dp))
        Row {
            Card(
                colors = CardDefaults.cardColors(white),
                elevation = CardDefaults.elevatedCardElevation(8.dp),
            ) {
                Column(
                    modifier
                        .padding(4.dp)
                        .size(60.dp)
                        .drawBehind({
                            val compSize = size / 1.25f
                            drawArc(
                                size = compSize,
                                style = Stroke(width = 20f, cap = StrokeCap.Round),
                                startAngle = 150f,
                                sweepAngle = 240f,
                                color = lightGraySubtitle,
                                useCenter = false,
                                topLeft = Offset(
                                    x = (size.width - compSize.width) / 2f,
                                    y = (size.height - compSize.height) / 2f
                                )
                            )

                            drawArc(
                                size = compSize,
                                style = Stroke(width = 20f, cap = StrokeCap.Round),
                                startAngle = 150f,
                                sweepAngle = (240 * popularity / 10),
                                color = brightGold,
                                useCenter = false,
                                topLeft = Offset(
                                    x = (size.width - compSize.width) / 2f,
                                    y = (size.height - compSize.height) / 2f
                                )
                            )
                        }), horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "$popularity",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "30000 Votes",
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
            Text(text = "Simba, a young lion prince, flees his kingdom after the murder of his father, Mufasa. Years later, a chance encounter with Nala, a lioness, causes him to return and take back what is rightfully his. Simba, a young lion prince, flees his kingdom after the murder of his father, Mufasa. Years later, a chance encounter with Nala, a lioness, causes him to return and take back what is rightfully his. Simba, a young lion prince, flees his kingdom after the murder of his father, Mufasa. Years later, a chance encounter with Nala, a lioness, causes him to return and take back what is rightfully his. Simba, a young lion prince, flees his kingdom after the murder of his father, Mufasa. Years later, a chance encounter with Nala, a lioness, causes him to return and take back what is rightfully his.")
        }
    }
}

@Composable
fun MovieProduction(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = 8.dp)
    ) {
        Text(
            text = stringResource(R.string.production_companies),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(count = 15) {
                ProdCompany()
            }
        }
    }
}

@Composable
private fun BottomButtons() {
    Row(modifier = Modifier.padding(8.dp)) {
        Button(
            onClick = {
                //todo add to favourites
            },
            colors = ButtonDefaults.buttonColors(darkRed),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = stringResource(R.string.already_watched))
        }
        Spacer(Modifier.width(8.dp))
        Button(
            onClick = {
                //todo add to favourites
            },
            colors = ButtonDefaults.buttonColors(darkGold),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = stringResource(R.string.watch_options))
        }
    }
}

@Composable
private fun Genres(genre: Genre) {
    Text(
        text = genre.name,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.horizontalGradient(
                    listOf<Color>(
                        darkReddish, darkGold
                    )
                )
            )
            .padding(vertical = 4.dp, horizontal = 8.dp),
        color = white,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
private fun ProdCompany() {
    Column(
        modifier = Modifier
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "production_company",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.height(4.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Company Name",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

