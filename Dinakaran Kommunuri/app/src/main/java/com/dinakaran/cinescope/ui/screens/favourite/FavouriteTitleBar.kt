package com.dinakaran.cinescope.ui.screens.favourite

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dinakaran.cinescope.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteTitleBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.favourite),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)
        }
    )
}